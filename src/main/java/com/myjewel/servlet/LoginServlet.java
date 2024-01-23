package com.myjewel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myjewel.beans.Message;
import com.myjewel.beans.User;
import com.myjewel.service.UserService;
import com.myjewel.utility.Factory;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("user_email");
		String password = request.getParameter("user_password");
		
		UserService userService = Factory.getUserService();
		User user = userService.getUserByEmailAndPassword(email, password);
		
		HttpSession httpSession = request.getSession();
		
		//TODO validations
		
		//authentication
		if(user!=null) {
			httpSession.setAttribute("messageObject", new Message(true, "Login successful!"));
			//login the suer
			httpSession.setAttribute("current_user", user);
			//admin login
			if(user.getUserType().equals("admin")) {
				response.sendRedirect("admin.jsp");
				
			//normal user login
			} else if(user.getUserType().equals("normal")) {
				//response.sendRedirect("normal.jsp");
				response.sendRedirect("index.jsp");
			} 
			
		} else {
			httpSession.setAttribute("messageObject", new Message(false, "Invalid Credentials.. User does not exist."));
			response.sendRedirect("login.jsp");
		}
		
	}
}
