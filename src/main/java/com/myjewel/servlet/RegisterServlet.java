package com.myjewel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myjewel.beans.Message;
import com.myjewel.beans.User;
import com.myjewel.entity.UserEntity;
import com.myjewel.service.UserService;
import com.myjewel.utility.Factory;
import com.myjewel.utility.HibernateUtility;

/**
 * Servlet implementation class Register
 */
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		String userName=request.getParameter("user_name");
		String userEmail=request.getParameter("user_email");
		String userPassword=request.getParameter("user_password");
		String userPhone=request.getParameter("user_phone");
		String userAddress=request.getParameter("user_address");
		
		String defaultUserType="normal";
		String defaultUserPic="default.jpg";
		User user = new User(userName, userEmail, userPassword, userPhone, userAddress, defaultUserPic, defaultUserType);
		
		HttpSession httpSession=request.getSession();
		try {
			UserService userService = Factory.getUserService();
			Integer userId = userService.addUser(user);
				
			httpSession.setAttribute("messageObject", new Message(true,"User registered successfully! ID : "+userId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			httpSession.setAttribute("messageObject", new Message(false,"Registration failed. Try again!"));
		}
		try {
			response.sendRedirect("register.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
