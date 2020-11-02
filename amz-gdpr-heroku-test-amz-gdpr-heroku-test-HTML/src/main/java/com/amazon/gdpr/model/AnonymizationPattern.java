package com.amazon.gdpr.model;



public class AnonymizationPattern {
	
	private int Anonymization_ID;	
	private String Anonymization_Name;	
	private String Field_Type;	
	private String Description;	
	private String Anonymization_Options;	
	private String Anonymization_Pattern;
	public int getAnonymization_ID() {
		return Anonymization_ID;
	}
	public void setAnonymization_ID(int anonymization_ID) {
		Anonymization_ID = anonymization_ID;
	}
	public String getAnonymization_Name() {
		return Anonymization_Name;
	}
	public void setAnonymization_Name(String anonymization_Name) {
		Anonymization_Name = anonymization_Name;
	}
	public String getField_Type() {
		return Field_Type;
	}
	public void setField_Type(String field_Type) {
		Field_Type = field_Type;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getAnonymization_Options() {
		return Anonymization_Options;
	}
	public void setAnonymization_Options(String anonymization_Options) {
		Anonymization_Options = anonymization_Options;
	}
	public String getAnonymization_Pattern() {
		return Anonymization_Pattern;
	}
	public void setAnonymization_Pattern(String anonymization_Pattern) {
		Anonymization_Pattern = anonymization_Pattern;
	}
	

}
