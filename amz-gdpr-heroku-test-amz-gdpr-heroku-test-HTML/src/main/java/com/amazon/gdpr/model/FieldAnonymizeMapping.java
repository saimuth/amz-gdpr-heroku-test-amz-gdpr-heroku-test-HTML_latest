package com.amazon.gdpr.model;




public class FieldAnonymizeMapping {

private int Mapping_Id	;
private int Impact_Field_Id	;
private int Category_Id	;
private int Country_Id	;
private String Policy_Criterion	;
private String Status	;
private int Anonymization_Id;
public int getMapping_Id() {
	return Mapping_Id;
}
public void setMapping_Id(int mapping_Id) {
	Mapping_Id = mapping_Id;
}
public int getImpact_Field_Id() {
	return Impact_Field_Id;
}
public void setImpact_Field_Id(int impact_Field_Id) {
	Impact_Field_Id = impact_Field_Id;
}
public int getCategory_Id() {
	return Category_Id;
}
public void setCategory_Id(int category_Id) {
	Category_Id = category_Id;
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
public int getAnonymization_Id() {
	return Anonymization_Id;
}
public void setAnonymization_Id(int anonymization_Id) {
	Anonymization_Id = anonymization_Id;
}

}
