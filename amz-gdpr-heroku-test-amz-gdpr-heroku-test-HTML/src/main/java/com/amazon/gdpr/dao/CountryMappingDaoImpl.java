package com.amazon.gdpr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.amazon.gdpr.configuration.DatabaseConfig;
import com.amazon.gdpr.model.CountryMapping;

public class CountryMappingDaoImpl implements CountryMappingDao{
	
	private Statement stmt;
	public CountryMappingDaoImpl() {
		System.out.println("CountryMappingDaoImpl :: CountryMappingDaoImpl : Connection establishment");
		try {
			Connection connection = new DatabaseConfig().getGDPRDBConnection();
	        stmt = connection.createStatement();
		}catch (Exception e) {
	    	System.out.println("CountryMappingDaoImpl :: CountryMappingDaoImpl : Connection exception");
	    	System.out.println("CountryMappingDaoImpl :: CountryMappingDaoImpl : "+e.toString());	        
	    }
	}
	
	@Override
	public List<CountryMapping> countryMappingList() {
		System.out.println("CountryMappingDaoImpl :: countryMappingList : started");
		List<CountryMapping> countryMappingList = null;
		
		try {	        
	        String sql = "SELECT * FROM \"heroku_depersonalisation\".\"country_code__c\"";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        System.out.println("CountryMappingDaoImpl :: countryMappingList : Fetched the resultset"+rs.getFetchSize());
	        countryMappingList = new ArrayList<CountryMapping>();
	        while (rs.next()) {
	        	CountryMapping countryMappingDtl = new CountryMapping(rs.getString("country_code__c"), rs.getString("country_name_full__c"), 
	        			rs.getTimestamp("createddate"), rs.getString("id"), rs.getBoolean("isdeleted"), 
	        			rs.getString("iso_alpha_3_country_code__c"),rs.getString("name"), rs.getString("sfid"), 
	        			rs.getTimestamp("systemmodstamp"));
	        	countryMappingList.add(countryMappingDtl);
				//System.out.println("CountryMappingDaoImpl :: countryMappingList : categoryDtl "+countryMappingDtl);
	        }
	        //model.addAttribute("users", users);	        
	    } catch (Exception e) {
	    	System.out.println("CountryMappingDaoImpl :: countryMappingList : exception");
	    	System.out.println("CountryMappingDaoImpl :: countryMappingList : "+e.toString());	        
	    }
		return countryMappingList;
	}
}
