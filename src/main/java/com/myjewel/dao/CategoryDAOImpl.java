package com.myjewel.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myjewel.beans.Category;
import com.myjewel.entity.CategoryEntity;
import com.myjewel.utility.HibernateUtility;

public class CategoryDAOImpl implements CategoryDAO {
	public Integer addCategory(Category category) {
		CategoryEntity categoryEntity = convertBeanToEntity(category);
		Integer id=null;
		try {
			Session hibernateSession = HibernateUtility.getSessionFactory().openSession();
			hibernateSession.beginTransaction();
			//id = (Integer)hibernateSession.save(categoryEntity);
			id = (Integer)hibernateSession.save(categoryEntity);
			hibernateSession.getTransaction().commit();
			hibernateSession.close();
		} catch(Exception e) {
			System.out.print(e);
		}
		
		return id;
	}
	public List<Category> getAllCategories(){
		List<Category> categoryList=new ArrayList<>();
		try {
			Session hibernateSession = HibernateUtility.getSessionFactory().openSession();
			hibernateSession.beginTransaction();
			String sql = "from CategoryEntity";
			Query query = hibernateSession.createQuery(sql);
			List<CategoryEntity> categoryEntityList = (List<CategoryEntity>)query.getResultList();
			for(CategoryEntity entity : categoryEntityList) {
				categoryList.add(convertEntityToBean(entity));
			}
			hibernateSession.getTransaction().commit();
			hibernateSession.close();
		} catch(Exception e) {
			System.out.print(e);
		}
		return categoryList;
	}
	public Category getCategoryById(Integer id) {
		Category category = null;
		try {
			Session hibernateSession = HibernateUtility.getSessionFactory().openSession();
			hibernateSession.beginTransaction();
			CategoryEntity categoryEntity = hibernateSession.find(CategoryEntity.class, id);
			category = convertEntityToBean(categoryEntity);
			hibernateSession.getTransaction().commit();
			hibernateSession.close();
		} catch(Exception e) {
			System.out.print(e);
		}
		return category;
	}
	
	public static CategoryEntity convertBeanToEntity(Category bean){
		if(bean==null) {
			return null;
		}
		CategoryEntity entity = new CategoryEntity();
		
		if(bean.getCategoryId() != null) {
			entity.setCategoryId(bean.getCategoryId());
		}
		entity.setCategoryTitle(bean.getCategoryTitle());
		entity.setCategoryDescription(bean.getCategoryDescription());
		return entity;
	}
	public static Category convertEntityToBean(CategoryEntity entity) {
		if(entity==null) {
			return null;
		}
		Category bean = new Category();
		bean.setCategoryId(entity.getCategoryId());
		bean.setCategoryTitle(entity.getCategoryTitle());
		bean.setCategoryDescription(entity.getCategoryDescription());
		return bean;
	}
}
