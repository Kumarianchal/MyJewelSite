<%@page import="com.myjewel.beans.Message"%>

<%
	Message messageObject=(Message)session.getAttribute("messageObject");
	
	if(messageObject != null){
		
%>

<div class="alert alert-<%=messageObject.getIsSuccess()?"success":"danger" %> alert-dismissible fade show" role="alert">
  <%= messageObject.getMessage() %>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

<%
	session.removeAttribute("messageObject");
	} 
%>

