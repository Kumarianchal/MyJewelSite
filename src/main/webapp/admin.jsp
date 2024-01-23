<%@page import="com.myjewel.beans.Message, com.myjewel.beans.User" %>

<%
	User user = (User)session.getAttribute("current_user");
	if(user == null){
		session.setAttribute("messageObject", new Message(false, "You are not logged in. Login to continue.."));
		response.sendRedirect("login.jsp");
		return;
	} else if(user.getUserType().equals("normal")){
		session.setAttribute("messageObject", new Message(false, "You are not authorized as admin."));
		response.sendRedirect("login.jsp");
		return;
	}
%>

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
	<div class="container-fluid">
		<%@include file="components/message.jsp"%>
	</div>

	<h4>Hello Admin user: <%=session.getAttribute("current_user") %></h4>
	
	<div class="container admin">
		<div class="row my-4 justify-content-center">
			<div class="col-md-3">
				<div class="card text-center align-items-center">
				  <img src="img/user.png" class="card-img-top admin-icon" alt="...">
				  <div class="card-body">
				    <h5 class="card-title">Users</h5>
				    <p class="card-text">57</p>
				  </div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card text-center  align-items-center">
				  <img src="img/categories.png" class="card-img-top admin-icon" alt="...">
				  <div class="card-body">
				    <h5 class="card-title">Categories</h5>
				    <p class="card-text">57</p>
				  </div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card text-center  align-items-center">
				  <img src="img/product.png" class="card-img-top admin-icon" alt="...">
				  <div class="card-body">
				    <h5 class="card-title">Products</h5>
				    <p class="card-text">57</p>
				  </div>
				</div>
			</div>
			
		</div>
		
		<div class="row my-3 justify-content-center">
			<div class="col-md-3">
				<div class="card text-center  align-items-center" data-bs-toggle="modal" data-bs-target="#add_category_modal">
				  <img src="img/plus.png" class="card-img-top  admin-icon" alt="...">
				  <div class="card-body">
				    <h5 class="card-title">Add Category</h5>
				  </div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card text-center  align-items-center" data-bs-toggle="modal" data-bs-target="#add_product_modal">
				  <img src="img/plus.png" class="card-img-top admin-icon" alt="...">
				  <div class="card-body">
				    <h5 class="card-title">Add Product</h5>
				  </div>
				</div>
			</div>
			
		</div>
	</div>
	
	
	<%@include file="components/add_category_modal.jsp" %>
	<%@include file="components/add_product_modal.jsp" %>
	<%@include file="components/cart_modal.jsp" %>
	
	<%@include file="components/common_js.jsp" %>
</body>
</html>