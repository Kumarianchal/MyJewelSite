package com.myjewel.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.myjewel.beans.User;
import com.myjewel.entity.UserEntity;
import com.myjewel.utility.HibernateUtility;

public class UserDAOImpl implements UserDAO {
	
	public Integer addUser(User user) {
		UserEntity userEntity=convertBeanToEntity(user);
		Integer userId=0;
		try {
			//transaction
			Session hibernateSession=HibernateUtility.getSessionFactory().openSession();
			hibernateSession.beginTransaction();
			userId=(Integer)hibernateSession.save(userEntity);
			hibernateSession.getTransaction().commit();
		} catch(Exception e) {
			System.out.print(e);
		}
		return userId;
	}
	
	public User getUserByEmailAndPassword(String email, String password) {
		User user=null;
		try {
			//transaction
			Session hibernateSession=HibernateUtility.getSessionFactory().openSession();
			hibernateSession.beginTransaction();
			String hql = "from UserEntity where userEmail =: e and userPassword =: p ";
			Query query = hibernateSession.createQuery(hql);
			query.setParameter("e", email);
			query.setParameter("p", password);
			
			UserEntity userEntity = (UserEntity)query.getSingleResult();
			user=convertEntityToBean(userEntity);
			hibernateSession.getTransaction().commit();
		} catch(Exception e) {
			System.out.print(e);
		}
		return user;
	}
	
	private UserEntity convertBeanToEntity(User userBean) {
		if(userBean == null){
			return null;
		}
		String userName=userBean.getUserName();
		String userEmail=userBean.getUserEmail();
		String userPassword=userBean.getUserPassword();
		String userPhone=userBean.getUserPhone();
		String userAddress=userBean.getUserPassword();
		String userType=userBean.getUserType();
		String userPic=userBean.getUserPic();
		
		UserEntity userEntity=new UserEntity(userName, userEmail, userPassword, userPhone, userAddress, userPic, userType);
		return userEntity;
	}
	private User convertEntityToBean(UserEntity userEntity) {
		if(userEntity == null){
			return null;
		}
		String userName=userEntity.getUserName();
		String userEmail=userEntity.getUserEmail();
		String userPassword=userEntity.getUserPassword();
		String userPhone=userEntity.getUserPhone();
		String userAddress=userEntity.getUserPassword();
		String userType=userEntity.getUserType();
		String userPic=userEntity.getUserPic();
		
		User user=new User(userName, userEmail, userPassword, userPhone, userAddress, userPic, userType);
		return user;
	}
	
}
