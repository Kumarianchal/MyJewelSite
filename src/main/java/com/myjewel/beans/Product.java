package com.myjewel.beans;

import javax.persistence.ManyToOne;

public class Product {
	private Integer productId;
	private String productName;
	private String productDescription;
	private Double productPrice;
	private Double productDiscount;
	private Integer productQuantity;
	private String productPic;
	@ManyToOne
	private Category category;
	
	public Product(Integer productId, String productName, String productDescription, Double productPrice,
			Double productDiscount, Integer productQuantity, String productPic, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productQuantity = productQuantity;
		this.productPic = productPic;
		this.category=category;
	}
	public Product(String productName, String productDescription, Double productPrice, Double productDiscount,
			Integer productQuantity, String productPic, Category category) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productQuantity = productQuantity;
		this.productPic = productPic;
		this.category=category;
	}
	public Product() {
		super();
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Double getProductDiscount() {
		return productDiscount;
	}
	public void setProductDiscount(Double productDiscount) {
		this.productDiscount = productDiscount;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getProductPic() {
		return productPic;
	}
	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productDiscount=" + productDiscount
				+ ", productQuantity=" + productQuantity + ", productPic=" + productPic + ", category=" + category
				+ "]";
	}
	
	public Double getDiscountedPrice() {
		Double discount = productDiscount/100*productPrice;
		return productPrice-discount;
	}
	
	
}
