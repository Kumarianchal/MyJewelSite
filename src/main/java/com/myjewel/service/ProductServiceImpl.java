package com.myjewel.service;

import java.util.List;

import com.myjewel.beans.Product;
import com.myjewel.dao.ProductDAO;
import com.myjewel.utility.Factory;

public class ProductServiceImpl implements ProductService{
	ProductDAO productDAO;
	
	public Integer addProduct(Product product) {
		productDAO = Factory.getProductDAO();
		Integer id = productDAO.addProduct(product);
		return id;
	}
	public List<Product> getAllProducts(){
		productDAO = Factory.getProductDAO();
		List<Product> productList = productDAO.getAllProducts();
		return productList;
	}
	public Product getProductById(Integer id) {
		productDAO = Factory.getProductDAO();
		Product product = productDAO.getProductById(id);
		return product;
	}
	public List<Product> getProductsByCategoryId(Integer catergoryId){
		productDAO = Factory.getProductDAO();
		List<Product> productList = productDAO.getProductsByCategoryId(catergoryId);
		return productList;
	}
}
