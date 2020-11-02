package com.amazon.gdpr.model;





public class Policy {
	
	private int Policy_ID	;
	private int Category_Id	;
	private String Country_Code	;
private int Country_Id	;
	private String Policy_Criterion	;	private String Status	;
	private String  Depersonalization_Condition;
	public int getPolicy_ID() {
		return Policy_ID;
	}
	public void setPolicy_ID(int policy_ID) {
		Policy_ID = policy_ID;
	}
	public int getCategory_Id() {
		return Category_Id;
	}
	public void setCategory_Id(int category_Id) {
		Category_Id = category_Id;
	}
	public String getCountry_Code() {
		return Country_Code;
	}
	public void setCountry_Code(String country_Code) {
		Country_Code = country_Code;
	}
	public int getCountry_Id() {
		return Country_Id;
	}
	public void setCountry_Id(int country_Id) {
		Country_Id = country_Id;
	}
	public String getPolicy_Criterion() {
		return Policy_Criterion;
	}
	public void setPolicy_Criterion(String policy_Criterion) {
		Policy_Criterion = policy_Criterion;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDepersonalization_Condition() {
		return Depersonalization_Condition;
	}
	public void setDepersonalization_Condition(String depersonalization_Condition) {
		Depersonalization_Condition = depersonalization_Condition;
	}
	
}

