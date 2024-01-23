package com.myjewel.service;

import java.util.List;

import com.myjewel.beans.Category;
import com.myjewel.dao.CategoryDAO;
import com.myjewel.utility.Factory;

public class CategoryServiceImpl implements CategoryService{
	
	CategoryDAO categoryDAO;
	
	public Integer addCategory(Category category) {
		categoryDAO = Factory.getCategoryDAO();
		Integer id = categoryDAO.addCategory(category);
		return id;
	}
	public List<Category> getAllCategories(){
		categoryDAO = Factory.getCategoryDAO();
		List<Category> categoryList = categoryDAO.getAllCategories();
		return categoryList;
	}
	public Category getCategoryById(Integer id) {
		categoryDAO = Factory.getCategoryDAO();
		Category category = categoryDAO.getCategoryById(id);
		return category;
	}
}
