<%@page import="java.io.File, java.util.List, com.myjewel.helper.Helper, com.myjewel.utility.HibernateUtility, com.myjewel.utility.Factory,
 com.myjewel.service.CategoryService, com.myjewel.service.ProductService, com.myjewel.beans.Category, com.myjewel.beans.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>MyJewel</title>
	<%@include file="components/common_css.jsp" %>
</head>
<body>
	<%@include file="components/navbar.jsp" %>
	<%@include file="components/message.jsp"%>
	<%@include file="components/common_js.jsp" %>
	<div class="container-fluid my-3 product">
		<div class="row">
			<% 
					String categoryParam = request.getParameter("category");
					Boolean showAllProducts = false;
					Integer categoryId = null;
					if(categoryParam==null || categoryParam.equals("all")){
						showAllProducts = true;
					} else{
						categoryId = Integer.parseInt(categoryParam);
					}
					
			%>
				
			<div class="col-md-2 my-2">
				<div class="list-group">
					<a href="index.jsp?category=all" class="list-group-item list-group-item-action <%=showAllProducts ? "active" : "" %>">All products</a>
				<% 
					CategoryService categoryService = Factory.getCategoryService();
					List<Category> categoryList = categoryService.getAllCategories();
					for(Category category : categoryList){
				%>
						<a href="index.jsp?category=<%=category.getCategoryId() %>" 
							class="list-group-item list-group-item-action <%= (!showAllProducts && category.getCategoryId().equals(categoryId)) ? "active" : "" %> "><%= category.getCategoryTitle() %></a>
				<%
					}
				%>
				</div>
			</div>
			
			<div class="col-md-10">
				<div class="row">
				
				<% 
					ProductService productService = Factory.getProductService();
				
					List<Product> productList = null;
					
					if(showAllProducts){
						productList = productService.getAllProducts();
					} else{
						productList = productService.getProductsByCategoryId(categoryId);
					}
					if(productList.isEmpty()){
						out.print("<h2>No product found in this category!</h2>");
					}
					String imgPath = "img" + File.separator + "products" 
							+ File.separator;
					Boolean inStock=false;
					for(Product product : productList){
						if(product.getProductQuantity()>0){
							inStock = true;
						}
				%>	
						<div class="col-md-4 my-2">
							<div class="card">
							  <img src="<%= imgPath + product.getProductPic()%>" class="card-img-top m-1" style="max-height:250px; max-width:100%; width:auto;" alt="...">
							  <div class="card-body">
							    <h5 class="card-title"><%= product.getProductName()%></h5> 
							    <p class="card-text"><%= Helper.getNWords(product.getProductDescription(), 10) %></p>
							    <a href="#" >More..</a>
							  </div>
							  <div class="card-footer">
							  	<div class="price flex">
							  		&#8377; <%= product.getDiscountedPrice() %>/-
								  	<span class="text-secondary price-display"><%= product.getProductPrice() %> </span>
								  	<span class="text-secondary discount-display"><%= product.getProductDiscount() %>% Off </span>
								  	<span class="stock-display"><%= inStock ? "Available" : "Out of Stock" %></span>
							  	</div>
							  	<button onclick="addToCart(<%=product.getProductId()%>, '<%=product.getProductName()%>', <%=product.getProductPrice()%>, <%=product.getProductQuantity()%>)" 
							  		class="btn btn-primary <%= (user1 == null || !inStock) ? "disabled" : "" %> ">
							  			Add To Cart
							  	</button>
							  </div>
							</div>
						</div>
				<%
					}
				%>
					
				</div>
			</div>
		</div>
	</div>
	
	
	<%@include file="components/common_js.jsp" %>
	<%@include file="components/cart_modal.jsp" %>
</body>
</html>