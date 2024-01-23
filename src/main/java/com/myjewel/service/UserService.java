package com.myjewel.service;

import com.myjewel.beans.User;

public interface UserService {
	Integer addUser(User user);
	User getUserByEmailAndPassword(String email, String password);
}
