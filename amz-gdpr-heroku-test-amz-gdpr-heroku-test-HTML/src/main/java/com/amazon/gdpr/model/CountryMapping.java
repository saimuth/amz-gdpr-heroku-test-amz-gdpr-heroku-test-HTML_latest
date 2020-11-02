package com.amazon.gdpr.model;

import java.sql.Timestamp;

public class CountryMapping {

	String countryCode;
	String countryNameFull;
	Timestamp createdDate;
	String id;
	Boolean isDeleted;
	String isoCountryCode;
	String name;
	String sfId;
	Timestamp systemmodstamp;
		
	public CountryMapping(String countryCode, String countryNameFull, Timestamp createdDate, String id, Boolean isDeleted,
			String isoCountryCode, String name, String sfId, Timestamp systemmodstamp) {
		super();
		this.countryCode = countryCode;
		this.countryNameFull = countryNameFull;
		this.createdDate = createdDate;
		this.id = id;
		this.isDeleted = isDeleted;
		this.isoCountryCode = isoCountryCode;
		this.name = name;
		this.sfId = sfId;
		this.systemmodstamp = systemmodstamp;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryNameFull() {
		return countryNameFull;
	}

	public void setCountryNameFull(String countryNameFull) {
		this.countryNameFull = countryNameFull;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getIsoCountryCode() {
		return isoCountryCode;
	}

	public void setIsoCountryCode(String isoCountryCode) {
		this.isoCountryCode = isoCountryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSfId() {
		return sfId;
	}

	public void setSfId(String sfId) {
		this.sfId = sfId;
	}

	public Timestamp getSystemmodstamp() {
		return systemmodstamp;
	}

	public void setSystemmodstamp(Timestamp systemmodstamp) {
		this.systemmodstamp = systemmodstamp;
	}
	
}