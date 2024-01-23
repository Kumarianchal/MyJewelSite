package com.myjewel.service;

import java.util.List;

import com.myjewel.beans.Category;

public interface CategoryService {
	Integer addCategory(Category category);
	List<Category> getAllCategories();
	Category getCategoryById(Integer id);
}
