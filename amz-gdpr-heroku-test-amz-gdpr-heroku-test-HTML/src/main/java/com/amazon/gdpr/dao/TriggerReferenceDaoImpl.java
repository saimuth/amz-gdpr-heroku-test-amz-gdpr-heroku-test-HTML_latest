package com.amazon.gdpr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amazon.gdpr.configuration.DatabaseConfig;
import com.amazon.gdpr.model.Category;
import com.amazon.gdpr.model.TriggerReference;

public class TriggerReferenceDaoImpl implements TriggerReferenceDao{
	private Statement stmt;
	public TriggerReferenceDaoImpl() {
		System.out.println("TriggerReferenceDaoImpl :: TriggerReferenceDaoImpl : Connection establishment");
		try {
			Connection connection = new DatabaseConfig().getArchiveDBConnection();
	        stmt = connection.createStatement();
		}catch (Exception e) {
	    	System.out.println("TriggerReferenceDaoImpl :: TriggerReferenceDaoImpl : Connection exception");
	    	System.out.println("TriggerReferenceDaoImpl :: TriggerReferenceDaoImpl : "+e.toString());	        
	    }
	}
	
	@Override
	public List<TriggerReference> triggerReferenceList() {
		System.out.println("TriggerReferenceDaoImpl :: triggerReferenceList : started");
		List<TriggerReference> triggerReferenceList = null;
		try {	        
	        String sql = "SELECT * FROM heroku_depersonalisation.triggerreference";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        System.out.println("TriggerReferenceDaoImpl :: triggerReferenceList : Fetched the resultset"+rs.getFetchSize());
	        triggerReferenceList = new ArrayList<TriggerReference>();
	        while (rs.next()) {
	        	TriggerReference triggerReferenceDtl = new TriggerReference();
	     
	        	triggerReferenceDtl.setTrigger_Ref_Id(rs.getInt("trigger_ref_id"));
	        	triggerReferenceDtl.setAbbreviation(rs.getString("abbreviation"));
	        	triggerReferenceDtl.setDetails(rs.getString("details"));
	        	triggerReferenceDtl.setField_Details(rs.getString("field_details"));
	        	triggerReferenceDtl.setCondition(rs.getString("condition"));
	        		        	
	        	triggerReferenceList.add(triggerReferenceDtl);
				System.out.println("TriggerReferenceDaoImpl :: triggerReferenceList : triggerReferenceDtl "+triggerReferenceDtl);
	        }
	    } catch (Exception e) {
	    	System.out.println("TriggerReferenceDaoImpl :: triggerReferenceList : exception");
	    	System.out.println("TriggerReferenceDaoImpl :: triggerReferenceList : "+e.toString());	        
	    }
		return triggerReferenceList;
	}
}