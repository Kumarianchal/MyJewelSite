package com.myjewel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "user_name", length = 100)
	private String userName;
	@Column(name = "user_email", length = 100)
	private String userEmail;
	@Column(name = "user_password", length = 20)
	private String userPassword;
	@Column(name = "user_phone", length = 20)
	private String userPhone;
	@Column(name = "user_address", length = 500)
	private String userAddress;
	@Column(name = "user_pic", length = 100)
	private String userPic;
	@Column(name = "user_type", length = 10)
	private String userType;

	public UserEntity(Integer userId, String userName, String userEmail, String userPassword, String userPhone,
			String userAddress, String userPic, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userPic = userPic;
		this.userType=userType;
	}

	public UserEntity(String userName, String userEmail, String userPassword, String userPhone, String userAddress,
			String userPic, String userType) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userPic = userPic;
		this.userType=userType;
	}

	public UserEntity() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userPhone=" + userPhone + ", userAddress=" + userAddress
				+ ", userPic=" + userPic + ", userType=" + userType + "]";
	}

}
