package com.amazon.gdpr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.amazon.gdpr.configuration.DatabaseConfig;
import com.amazon.gdpr.model.AnonymizationPattern;
import com.amazon.gdpr.model.Category;
import com.amazon.gdpr.model.CountryCode;
import com.amazon.gdpr.model.CountryMapping;

public class AnonymizationPatternDaoImpl implements AnonymizationPatternDao{
	
	private Statement stmt;
	public AnonymizationPatternDaoImpl() {
		System.out.println("AnonymizationPatternDaoImpl :: AnonymizationPatternDaoImpl : Connection establishment");
		try {
			Connection connection = new DatabaseConfig().getArchiveDBConnection();
	        stmt = connection.createStatement();
		}catch (Exception e) {
	    	System.out.println("AnonymizationPatternDaoImpl :: AnonymizationPatternDaoImpl : Connection exception");
	    	System.out.println("AnonymizationPatternDaoImpl :: AnonymizationPatternDaoImpl : "+e.toString());	        
	    }
	}
	

	@Override
	public List<AnonymizationPattern> AnonymizationPatternList() {
		System.out.println("AnonymizationPatternDaoImpl :: AnonymizationPatternList : started");
		List<AnonymizationPattern> anonymizationPatternList = null;
		
		try {	        
	        String sql = "SELECT * FROM heroku_depersonalisation .anonymizationpatten";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        System.out.println("AnonymizationPatternList :: AnonymizationPatternList : Fetched the resultset"+rs.getFetchSize());
	        anonymizationPatternList = new ArrayList<AnonymizationPattern>();
	     
	      
	        while (rs.next()) {
	        	AnonymizationPattern anonymizationPatternListDtl = new AnonymizationPattern();
	        
	        	anonymizationPatternListDtl.setAnonymization_ID(rs.getInt("anonymization_id"));
	        	anonymizationPatternListDtl.setAnonymization_Name(rs.getString("anonymization_name"));
	        	anonymizationPatternListDtl.setField_Type(rs.getString("field_type"));
	        	anonymizationPatternListDtl.setDescription(rs.getString("description"));
	        	anonymizationPatternListDtl.setAnonymization_Options(rs.getString("anonymization_options"));
	        	anonymizationPatternListDtl.setAnonymization_Pattern(rs.getString("anonymization_pattern"));
	        	anonymizationPatternList.add(anonymizationPatternListDtl);
				System.out.println("AnonymizationPatternDaoImpl :: anonymizationPatternList : anonymizationPatternListDtl "+anonymizationPatternListDtl);
	        }
	    } catch (Exception e) {
	    	System.out.println("AnonymizationPatternDaoImpl :: AnonymizationPatternList : exception");
	    	System.out.println("AnonymizationPatternDaoImpl :: AnonymizationPatternList : "+e.toString());	        
	    }
		return anonymizationPatternList;

	}
}
