package com.amazon.gdpr.model;

import java.sql.Timestamp;

public class User {
	long id;
	String sfid;
	String username;
	String alias;
	String name;
	Timestamp createdDate;
	Timestamp systemmodstamp;

	public User() {		
	}
	
	public User(long id, String sfid, String username, String alias, String name, Timestamp createdDate,
			Timestamp systemmodstamp) {
		super();
		this.id = id;
		this.sfid = sfid;
		this.username = username;
		this.alias = alias;
		this.name = name;
		this.createdDate = createdDate;
		this.systemmodstamp = systemmodstamp;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSfid() {
		return sfid;
	}
	public void setSfid(String sfid) {
		this.sfid = sfid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getSystemmodstamp() {
		return systemmodstamp;
	}
	public void setSystemmodstamp(Timestamp systemmodstamp) {
		this.systemmodstamp = systemmodstamp;
	}
}