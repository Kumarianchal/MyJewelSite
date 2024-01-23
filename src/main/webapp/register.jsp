<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<%@include file="components/common_css.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	

	<div class="row">

		<div class="col-md-4 offset-md-4 my-3">
			<%@include file="components/message.jsp"%>
			<div class="card">
				<div class="card-body">
				
					<h3 class="text-center my-4">Sign Up</h3>
					
					<form action="RegisterServlet" method="post">
						<div class="form-group mb-3">
							<label for="user_name" class="form-label">Name</label> 
							<input type="text" name="user_name" class="form-control" id="user_name">
						</div>

						<div class="form-group mb-3">
							<label for="user_email" class="form-label">Email</label> 
							<input type="email" name="user_email" class="form-control" id="user_email" aria-describedby="emailHelp">
								
						</div>
						<div class="form-group mb-3">
							<label for="user_password" class="form-label">Password</label>
							<input type="password" name="user_password" class="form-control" id="user_password">
						</div>
						<div class="form-group mb-3">
							<label for="user_phone" class="form-label">Contact</label> 
							<input type="text" name="user_phone" class="form-control" id="user_phone">
						</div>
						<div class="form-group mb-3">
							<label for="user_address" class="form-label">Address</label>
							<textarea class="form-control" name="user_address" id="user_address" rows="3"></textarea>
						</div>

						<div class="container text-center">
							<button type="submit" class="btn btn-success">Register</button>
							<button type="reset" class="btn btn-primary">Reset</button>
						</div>

					</form>
				</div>
			</div>


		</div>

	</div>


	<%@include file="components/common_js.jsp"%>
</body>
</html>