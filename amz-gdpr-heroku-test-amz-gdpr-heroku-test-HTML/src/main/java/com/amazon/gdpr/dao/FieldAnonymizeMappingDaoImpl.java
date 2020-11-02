package com.amazon.gdpr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amazon.gdpr.configuration.DatabaseConfig;
import com.amazon.gdpr.model.Category;
import com.amazon.gdpr.model.FieldAnonymizeMapping;
import com.amazon.gdpr.model.TriggerReference;

public class FieldAnonymizeMappingDaoImpl implements FieldAnonymizeMappingDao{
	private Statement stmt;
	public FieldAnonymizeMappingDaoImpl() {
		System.out.println("FieldAnonymizeMappingDaoImpl :: FieldAnonymizeMappingDaoImpl : Connection establishment");
		try {
			Connection connection = new DatabaseConfig().getArchiveDBConnection();
	        stmt = connection.createStatement();
		}catch (Exception e) {
	    	System.out.println("FieldAnonymizeMappingDaoImpl :: FieldAnonymizeMappingDaoImpl : Connection exception");
	    	System.out.println("FieldAnonymizeMappingDaoImpl :: FieldAnonymizeMappingDaoImpl : "+e.toString());	        
	    }
	}
	
	@Override
	public List<FieldAnonymizeMapping> fieldAnonymizeMappingList() {
		System.out.println("FieldAnonymizeMappingDaoImpl :: fieldAnonymizeMappingList : started");
		List<FieldAnonymizeMapping> fieldAnonymizeMappingList = null;
		try {	        
	        String sql = "SELECT * FROM heroku_depersonalisation.fieldanonymizemapping";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        System.out.println("FieldAnonymizeMappingDaoImpl :: fieldAnonymizeMappingList : Fetched the resultset"+rs.getFetchSize());
	        fieldAnonymizeMappingList = new ArrayList<FieldAnonymizeMapping>();
	        while (rs.next()) {
	        	FieldAnonymizeMapping fieldAnonymizeMappingDtl = new FieldAnonymizeMapping();
	        	
	        	fieldAnonymizeMappingDtl.setMapping_Id(rs.getInt("mapping_id"));
	        	fieldAnonymizeMappingDtl.setImpact_Field_Id(rs.getInt("impact_field_id"));
	        	fieldAnonymizeMappingDtl.setCategory_Id(rs.getInt("category_id"));
	        	fieldAnonymizeMappingDtl.setCountry_Id(rs.getInt("country_id"));
	        	fieldAnonymizeMappingDtl.setPolicy_Criterion(rs.getString("policy_criterion"));
	        	fieldAnonymizeMappingDtl.setStatus(rs.getString("status"));
	        	fieldAnonymizeMappingDtl.setAnonymization_Id(rs.getInt("anonymization_id"));
	       
	      		        	
	        	fieldAnonymizeMappingList.add(fieldAnonymizeMappingDtl);
				System.out.println("FieldAnonymizeMappingDaoImpl :: fieldAnonymizeMappingList : triggerReferenceDtl "+fieldAnonymizeMappingDtl);
	        }
	    } catch (Exception e) {
	    	System.out.println("FieldAnonymizeMappingDaoImpl :: fieldAnonymizeMappingList : exception");
	    	System.out.println("FieldAnonymizeMappingDaoImpl :: fieldAnonymizeMappingList : "+e.toString());	        
	    }
		return fieldAnonymizeMappingList;
	}
}