<!--Add Product Modal -->
<div class="modal fade" id="add_product_modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Product Details</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="OperationServlet" method="post" enctype="multipart/form-data">
        
        	<input type="hidden" name="operation" value="add_product">
        	
			<div class="form-group mb-3">
				<label for="product_name" class="form-label">Product Name</label> 
				<input name="product_name" type="text" class="form-control" id="product_name">
			</div>
			<div class="form-group mb-3">
				<label for="product_description" class="form-label">Product Description</label> 
				<input name="product_description" type="text" class="form-control" id="product_description">
			</div>
			<div class="form-group mb-3">
				<label for="product_quantity" class="form-label">Product Quantity</label> 
				<input name="product_quantity" type="text" class="form-control" id="product_quantity">
			</div>
			<div class="form-group mb-3">
				<label for="product_price" class="form-label">Product Price</label> 
				<input name="product_price" type="text" class="form-control" id="product_price">
			</div>
			<div class="form-group mb-3">
				<label for="product_discount" class="form-label">Product Discount</label> 
				<input name="product_discount" type="text" class="form-control" id="product_discount">
			</div>
			<div class="form-group mb-3">
				<label for="product_picture" class="form-label">Select Product Picture</label> 
				<input name="product_picture" type="file" class="form-control" id="product_picture">
			</div>
			
			<%@page import="com.myjewel.service.CategoryService, 
				com.myjewel.utility.Factory, com.myjewel.beans.Category, java.util.List" %>
			
			<%
				CategoryService categoryService = Factory.getCategoryService();
				List<Category> categoryList = categoryService.getAllCategories();
			%>
			
			<div class="form-group mb-3">
				<label for="product_category" class="form-label" id="product_category">Product Category</label> 
				<select name="product_category" class="form-control" >
					<%for(Category category : categoryList) { %>
						<option value=<%=(int)category.getCategoryId() %>>
							<%= category.getCategoryTitle() %>
						</option>
					<%} %>
				</select>
			</div>

			<div class="container text-center my-3">
				<button type="submit" class="btn btn-success">Add</button>
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>
			</div>
		</form>
      </div>
    </div>
  </div>
</div>