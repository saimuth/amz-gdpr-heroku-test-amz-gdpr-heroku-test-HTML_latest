package com.amazon.gdpr.model;




public class TriggerReference {
  
	private int Trigger_Ref_Id;
	private String Abbreviation; 
	private String Details;
	private String Field_Details;
	private String Condition;
	
	public int getTrigger_Ref_Id() {
		return Trigger_Ref_Id;
	}
	public void setTrigger_Ref_Id(int trigger_Ref_Id) {
		Trigger_Ref_Id = trigger_Ref_Id;
	}
	public String getAbbreviation() {
		return Abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		Abbreviation = abbreviation;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	public String getField_Details() {
		return Field_Details;
	}
	public void setField_Details(String field_Details) {
		Field_Details = field_Details;
	}
	public String getCondition() {
		return Condition;
	}
	public void setCondition(String condition) {
		Condition = condition;
	}
	
	
	
}
	