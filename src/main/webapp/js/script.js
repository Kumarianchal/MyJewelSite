
function addToCart(pid, pname, pprice, pquantity){
	let product = {productId : pid, productName : pname, productPrice : pprice, productQuantity : 1, inStockQuantity : pquantity};
	if(localStorage.getItem("cart") == null){
		let productList = [];
		console.log("Cart created");
		if(pquantity>0){
			productList.push(product);
		}
		localStorage.setItem("cart", JSON.stringify(productList));
	} else{
		let products = localStorage.getItem("cart");
		let productList = JSON.parse(products);
		let existingProduct = productList.find(p => p.productId==pid);
		if(existingProduct == null){
			if(pquantity>0){
				productList.push(product);
			}
			console.log("New product added to cart");
		} else{
			productList.map((item)=>{
				if(item.productId == existingProduct.productId){
					let requiredQuantity = item.productQuantity+1;
					if(requiredQuantity > pquantity){
						console.log("No more stock for this product");
						alert("No more stock for this product");
					} else{
						item.productQuantity = requiredQuantity;
						console.log("Quantity of existing product increased");
					}
				
				}
			})
		}
		
		
	    localStorage.setItem("cart", JSON.stringify(productList));
	}
	updateCart();
}

function decreaseItemQuantityInCart(pId){
	let products = localStorage.getItem("cart");
	let productList = JSON.parse(products);
	let removeItem = false;
	productList.map((item)=>{
		if(item.productId == pId){
			if(item.productQuantity > 0){
				item.productQuantity = item.productQuantity - 1;
				console.log("Decreased item quantity in cart");
			}
			if(item.productQuantity == 0){
				removeItem=true;
			}
		}
	})
	localStorage.setItem("cart", JSON.stringify(productList));
	if(removeItem){
		deleteFromCart(pId);
	}
	updateCart();
}

function deleteFromCart(pId){
	let products = localStorage.getItem("cart");
	let productList = JSON.parse(products);
	let newProductList = productList.filter((item)=>item.productId!=pId);
	localStorage.setItem("cart", JSON.stringify(newProductList));
	console.log("Deleted from cart");
	updateCart();
}

function updateCart(){
	let cartString = localStorage.getItem("cart");
	let cart = JSON.parse(cartString);
	if(cart==null || cart.length==0){
		console.log("Cart is empty!");
		$(".cart-items").html("(0)");
		$(".cart-body").html("<h3>Cart does not have any items</h3>");
		$(".checkout-btn").addClass('disabled');
	} else{
		console.log(cart);
		$(".cart-items").html(`(${cart.length})`);
		$(".checkout-btn").removeClass('disabled');
		let totalPrice=0.0;
		let cartTable = 
			`<table class="table text-center">
				<thead>
					<tr>
						<th>Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Actions</th>
						<th>Total</th>
					</tr>
				</thead>
				<tbody>`;
				
		cart.map((items)=>{
			let table = 
				`<tr>
					<td>${items.productName}</td>
					<td>${items.productPrice}</td>
					<td>${items.productQuantity}</td>
					<td>
						<button class="fa fa-plus" onclick="addToCart(${items.productId},'${items.productName}', ${items.productPrice},  ${items.inStockQuantity})"></button>
						<button class="fa fa-minus" onclick="decreaseItemQuantityInCart(${items.productId})"></button>
						<button class="fas fa-trash-alt" onclick="deleteFromCart(${items.productId})"></button>
					</td>
					<td>${items.productQuantity*items.productPrice}</td>
				</tr>`;
			cartTable = cartTable+table;
			totalPrice+=(items.productQuantity*items.productPrice);
		})
		cartTable=cartTable+`<tr> <td colspan="5" class="font-weight-bold">Sum Total : ${totalPrice}</td></tr>`	;
		cartTable = cartTable +	`</tbody></table>`;
		$(".cart-body").html(cartTable);
	}
	console.log("cart updated");
}

$(document).ready(function(){
	updateCart();
})

