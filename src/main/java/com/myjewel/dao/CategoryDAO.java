package com.myjewel.dao;

import java.util.List;

import com.myjewel.beans.Category;

public interface CategoryDAO {
	Integer addCategory(Category category);
	List<Category> getAllCategories();
	Category getCategoryById(Integer id);
}
