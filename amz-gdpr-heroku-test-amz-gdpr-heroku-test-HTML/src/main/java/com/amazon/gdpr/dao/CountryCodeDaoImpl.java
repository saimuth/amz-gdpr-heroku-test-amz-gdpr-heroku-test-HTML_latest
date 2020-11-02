package com.amazon.gdpr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.amazon.gdpr.configuration.DatabaseConfig;
import com.amazon.gdpr.model.Category;
import com.amazon.gdpr.model.CountryCode;
import com.amazon.gdpr.model.CountryMapping;

public class CountryCodeDaoImpl implements CountryCodeDao{
	
	private Statement stmt;
	public CountryCodeDaoImpl() {
		System.out.println("CountryCodeDaoImpl :: CountryCodeDaoImpl : Connection establishment");
		try {
			Connection connection = new DatabaseConfig().getArchiveDBConnection();
	        stmt = connection.createStatement();
		}catch (Exception e) {
	    	System.out.println("CountryCodeDaoImpl :: CountryCodeDaoImpl : Connection exception");
	    	System.out.println("CountryCodeDaoImpl :: CountryCodeDaoImpl : "+e.toString());	        
	    }
	}
	
	

	@Override
	public List<CountryCode> countryCodeList() {
		System.out.println("CountryCodeDaoImpl :: countryCodeList : started");
		List<CountryCode> countryCodeList = null;
		
		try {	        
	        String sql = "SELECT * FROM heroku_depersonalisation .country_code__c";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        System.out.println("countryCodeList :: countryCodeList : Fetched the resultset"+rs.getFetchSize());
	        countryCodeList = new ArrayList<CountryCode>();
	     
	      
	        while (rs.next()) {
	        	CountryCode countryCodeDtl = new CountryCode();
	        	countryCodeDtl.setCountry_ID(rs.getInt("country_id"));
	        	countryCodeDtl.setRegion(rs.getString("region"));  
	        	countryCodeDtl.setCountry_Code(rs.getString("country_code"));
	        	countryCodeDtl.setCountry_Name(rs.getString("country_name"));
	        	countryCodeDtl.setStatus(rs.getString("status"));
	        	countryCodeList.add(countryCodeDtl);
				System.out.println("CountryCodeDaoImpl :: countryCodeList : countryCodeDtl "+countryCodeDtl);
	        }
	    } catch (Exception e) {
	    	System.out.println("CountryCodeDaoImpl :: countryCodeList : exception");
	    	System.out.println("CountryCodeDaoImpl :: countryCodeList : "+e.toString());	        
	    }
		return countryCodeList;
	}
}
