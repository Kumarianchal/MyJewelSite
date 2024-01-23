<%@page import="com.myjewel.beans.User" %>
<% 
	User user1 = (User)session.getAttribute("current_user");
%>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container">
		<div class="container-fluid">
			
			
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<a class="navbar-brand" href="index.jsp">MyJewel</a>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">Home</a></li>
						
					<% if(user1!=null && user1.getUserType().equalsIgnoreCase("admin")) { %>
						<li class="nav-item"><a class="nav-link active" href="admin.jsp">Admin Panel</a>
						</li>
					<%} %>
					
				</ul>
				<% if(user1 == null) { %>
					<ul class="navbar-nav ml-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="login.jsp">Login</a>
						</li>
						<li class="nav-item"><a class="nav-link active" href="register.jsp">Register</a>
						</li>
					</ul>
				<%} else { %>
				
					<ul class="navbar-nav ml-auto mb-2 mb-lg-0">
						
						<li class="nav-item nav-link active cart-navbar" data-bs-toggle="modal" data-bs-target="#cart_modal">
							<i class="fa fa-cart-plus fa-lg "></i><span class="cart-items">(0)</span>
						</li>
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="#"><%= user1.getUserName() %></a>
						</li>
						<li class="nav-item">
							<a class="nav-link active" href="LogoutServlet">Logout</a>
						</li>
						
					</ul>
				<%} %>
			</div>
		</div>
	</div>

</nav>