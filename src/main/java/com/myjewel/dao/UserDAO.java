package com.myjewel.dao;

import com.myjewel.beans.User;

public interface UserDAO {
	Integer addUser(User user);
	User getUserByEmailAndPassword(String email, String password);
}
