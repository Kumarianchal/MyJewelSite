<%@page import="com.myjewel.beans.Message, com.myjewel.beans.User" %>

<%
	User user = (User)session.getAttribute("current_user");
	if(user == null){
		session.setAttribute("messageObject", new Message(false, "You are not logged in. Login to continue.."));
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
	<%@include file="components/message.jsp"%>

	<h1>Hello Normal user: <%=session.getAttribute("current_user") %></h1>
	
	<%@include file="components/cart_modal.jsp" %>
	<%@include file="components/common_js.jsp" %>
</body>
</html>