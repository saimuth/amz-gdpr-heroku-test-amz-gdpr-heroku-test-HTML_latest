package com.amazon.gdpr.model;

public class Category {
	int categoryId;
	String categoryName;
	String Status;

	public Category() {		
	}
	
	public Category(int categoryId, String categoryName, String status) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		Status = status;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
		
}