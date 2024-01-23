<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@include file="components/common_css.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="container">
		<div class="row" >
			<div class="col-md-6 offset-md-3 my-3">
				<%@include file="components/message.jsp"%>
				<div class="card">
					<div class="card-body">
						<h3 class="text-center my-4">Login</h3>
						<form action="LoginServlet" method="post">

							<div class="form-group mb-3">
								<label for="user_email" class="form-label">Email</label> 
								<input name="user_email" type="email" name="user_email" class="form-control" id="user_email" aria-describedby="emailHelp">

							</div>
							<div class="form-group mb-3">
								<label for="user_password" class="form-label">Password</label>
								<input name="user_password" type="password" name="user_password" class="form-control" id="user_password">
							</div>
							<a href="register.jsp">Don't have an account? Click here.</a>
							<div class="container text-center my-3">
								<button type="submit" class="btn btn-success">Login</button>
								<button type="reset" class="btn btn-primary">Reset</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="components/common_js.jsp"%>
</body>
</html>