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
import com.amazon.gdpr.model.ImpactField;
import com.amazon.gdpr.model.ImpactTable;

public class ImpactFieldDaoImpl implements ImpactFieldDao{
	
	private Statement stmt;
	public ImpactFieldDaoImpl() {
		System.out.println("ImpactFieldDaoImpl :: ImpactFieldDaoImpl : Connection establishment");
		try {
			Connection connection = new DatabaseConfig().getArchiveDBConnection();
	        stmt = connection.createStatement();
		}catch (Exception e) {
	    	System.out.println("ImpactFieldDaoImpl :: ImpactFieldDaoImpl : Connection exception");
	    	System.out.println("ImpactFieldDaoImpl :: ImpactFieldDaoImpl : "+e.toString());	        
	    }
	}
	
	@Override
	public List<ImpactField> impactFieldList() {
		System.out.println("ImpactFieldDaoImpl :: impactFieldList : started");
		List<ImpactField> impactFieldList = null;
		
		try {	        
	        String sql = "SELECT * FROM heroku_depersonalisation .impactfield";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        System.out.println("impactFieldList :: impactFieldList : Fetched the resultset"+rs.getFetchSize());
	        impactFieldList = new ArrayList<ImpactField>();
	     
	      
	        while (rs.next()) {
	        	ImpactField impactFieldListDtl = new ImpactField();
	        	impactFieldListDtl.setImpact_Field_Id(rs.getInt("impact_field_id"));
	        	impactFieldListDtl.setImpact_Table_Id(rs.getInt("impact_table_id"));
	        	impactFieldListDtl.setImpact_Field_Name(rs.getString("impact_field_name"));
	        	impactFieldListDtl.setImpact_Field_Type(rs.getString("impact_field_type"));
	        	
	        	impactFieldList.add(impactFieldListDtl);
				System.out.println("ImpactFieldDaoImpl :: impactFieldList : impactFieldListDtl "+impactFieldListDtl);
	        }
	    } catch (Exception e) {
	    	System.out.println("ImpactFieldDaoImpl :: impactFieldList : exception");
	    	System.out.println("ImpactFieldDaoImpl :: impactFieldList : "+e.toString());	        
	    }
		return impactFieldList;
	}
}
