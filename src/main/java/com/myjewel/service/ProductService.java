package com.myjewel.service;

import java.util.List;

import com.myjewel.beans.Product;

public interface ProductService {
	Integer addProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(Integer id);
	List<Product> getProductsByCategoryId(Integer catergoryId);
}
