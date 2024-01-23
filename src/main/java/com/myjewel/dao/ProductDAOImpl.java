package com.myjewel.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.myjewel.beans.Category;
import com.myjewel.beans.Product;
import com.myjewel.entity.CategoryEntity;
import com.myjewel.entity.ProductEntity;
import com.myjewel.utility.HibernateUtility;

public class ProductDAOImpl implements ProductDAO {
	public Integer addProduct(Product product) {
		Session hibernateSession = HibernateUtility.getSessionFactory().openSession();
		ProductEntity productEntity = convertBeanToEntity(product);
		hibernateSession.beginTransaction();
		Integer id = (Integer) hibernateSession.save(productEntity);
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return id;
	}

	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<>();
		Session hibernateSession = HibernateUtility.getSessionFactory().openSession();
		hibernateSession.beginTransaction();
		String sql = "from ProductEntity";
		Query query = hibernateSession.createQuery(sql);
		List<ProductEntity> productEntityList = (List<ProductEntity>) query.getResultList();
		for (ProductEntity entity : productEntityList) {
			productList.add(convertEntityToBean(entity));
		}
		hibernateSession.getTransaction().commit();
		return productList;
	}
	
	public Product getProductById(Integer id) {
		Session hibernateSession = HibernateUtility.getSessionFactory().openSession();
		hibernateSession.beginTransaction();
		ProductEntity productEntity = hibernateSession.find(ProductEntity.class, id);
		Product product = convertEntityToBean(productEntity);
		hibernateSession.getTransaction().commit();
		return product;
	}
	public List<Product> getProductsByCategoryId(Integer categoryId){
		List<Product> productList = new ArrayList<>();
		Session hibernateSession = HibernateUtility.getSessionFactory().openSession();
		hibernateSession.beginTransaction();
		String sql = "from ProductEntity p where p.category.categoryId =: cid";
		Query query = hibernateSession.createQuery(sql);
		query.setParameter("cid", categoryId);
		
		List<ProductEntity> productEntityList = (List<ProductEntity>) query.getResultList();
		for (ProductEntity entity : productEntityList) {
			productList.add(convertEntityToBean(entity));
		}
		hibernateSession.getTransaction().commit();
		return productList;
	}
	public static ProductEntity convertBeanToEntity(Product product) {
		ProductEntity productEntity = new ProductEntity();

		if (product.getProductId() != null) {
			productEntity.setProductId(product.getProductId());
		}
		productEntity.setProductName(product.getProductName());
		productEntity.setProductDescription(product.getProductDescription());
		productEntity.setProductQuantity(product.getProductQuantity());
		productEntity.setProductPrice(product.getProductPrice());
		productEntity.setProductDiscount(product.getProductDiscount());
		productEntity.setProductPic(product.getProductPic());

		Category category = product.getCategory();
		CategoryEntity categoryEntity = CategoryDAOImpl.convertBeanToEntity(category);
		productEntity.setCategory(categoryEntity);
		return productEntity;
	}

	public static Product convertEntityToBean(ProductEntity productEntity) {
		Product product = new Product();
		
		product.setProductId(productEntity.getProductId());
		product.setProductName(productEntity.getProductName());
		product.setProductDescription(productEntity.getProductDescription());
		product.setProductQuantity(productEntity.getProductQuantity());
		product.setProductPrice(productEntity.getProductPrice());
		product.setProductDiscount(productEntity.getProductDiscount());
		product.setProductPic(productEntity.getProductPic());

		CategoryEntity categoryEntity = productEntity.getCategory();
		Category category = CategoryDAOImpl.convertEntityToBean(categoryEntity);
		product.setCategory(category);
		return product;
	}

}
