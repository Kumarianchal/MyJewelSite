package com.myjewel.dao;

import java.util.List;

import com.myjewel.beans.Category;
import com.myjewel.beans.Product;

public interface ProductDAO {
	Integer addProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(Integer id);
	List<Product> getProductsByCategoryId(Integer catergoryId);
}
