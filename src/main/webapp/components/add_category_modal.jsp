<!--Add Category Modal -->
<div class="modal fade" id="add_category_modal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel">Category
					Details</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form action="OperationServlet" method="post">
				
					<input type="hidden" name="operation" value="add_category">
					<div class="form-group mb-3">
						<label for="category_title" class="form-label">Category
							Title</label> <input name="category_title" type="text"
							class="form-control" id="category_title">

					</div>
					<div class="form-group mb-3">
						<label for="category_description" class="form-label">Category
							Description</label> <input name="category_description" type="text"
							class="form-control" id="category_description">
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