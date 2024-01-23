package com.myjewel.utility;

import com.myjewel.dao.CategoryDAO;
import com.myjewel.dao.CategoryDAOImpl;
import com.myjewel.dao.ProductDAO;
import com.myjewel.dao.ProductDAOImpl;
import com.myjewel.dao.UserDAO;
import com.myjewel.dao.UserDAOImpl;
import com.myjewel.service.CategoryService;
import com.myjewel.service.CategoryServiceImpl;
import com.myjewel.service.ProductService;
import com.myjewel.service.ProductServiceImpl;
import com.myjewel.service.UserService;
import com.myjewel.service.UserServiceImpl;

public class Factory {
	public static UserDAO getUserDAO(){
		return new UserDAOImpl();
	}
	
	public static UserService getUserService(){
		return new UserServiceImpl();
	}
	
	public static CategoryDAO getCategoryDAO(){
		return new CategoryDAOImpl();
	}
	
	public static CategoryService getCategoryService(){
		return new CategoryServiceImpl();
	}

	public static ProductDAO getProductDAO(){
		return new ProductDAOImpl();
	}
	
	public static ProductService getProductService(){
		return new ProductServiceImpl();
	}
	
}
