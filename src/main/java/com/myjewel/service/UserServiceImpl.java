package com.myjewel.service;

import com.myjewel.beans.User;
import com.myjewel.dao.UserDAO;
import com.myjewel.utility.Factory;

public class UserServiceImpl implements UserService {
	
	UserDAO userDAO;
	
	public Integer addUser(User user) {
		userDAO = Factory.getUserDAO();	
		Integer userId = userDAO.addUser(user);
		return userId;
	}
	public User getUserByEmailAndPassword(String email, String password) {
		userDAO = Factory.getUserDAO();	
		User user = userDAO.getUserByEmailAndPassword(email, password);
		return user;
	}
}
