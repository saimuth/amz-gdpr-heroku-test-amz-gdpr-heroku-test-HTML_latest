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

public class ImpactTableDaoImpl implements ImpactTableDao{
	
	private Statement stmt;
	public ImpactTableDaoImpl() {
		System.out.println("ImpactTableDaoImpl :: ImpactTableDaoImpl : Connection establishment");
		try {
			Connection connection = new DatabaseConfig().getArchiveDBConnection();
	        stmt = connection.createStatement();
		}catch (Exception e) {
	    	System.out.println("ImpactTableDaoImpl :: ImpactTableDaoImpl : Connection exception");
	    	System.out.println("ImpactTableDaoImpl :: ImpactTableDaoImpl : "+e.toString());	        
	    }
	}
	

	


	@Override
	public List<ImpactTable> impactTableList() {
		System.out.println("ImpactTableDaoImpl :: impactTableList : started");
		List<ImpactTable> impactTableList = null;
		
		try {	        
	        String sql = "SELECT * FROM heroku_depersonalisation .impacttable";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        System.out.println("ImpactTableDaoImpl :: ImpactTableList : Fetched the resultset"+rs.getFetchSize());
	        impactTableList = new ArrayList<ImpactTable>();
	     
	      
	        while (rs.next()) {
	        	ImpactTable impactTableListDtl = new ImpactTable();
	        	impactTableListDtl.setImpact_Table_Id(rs.getInt("impact_table_id"));
	        	impactTableListDtl.setImpact_Table_Name(rs.getString("impact_table_name"));
	        	
	        	impactTableList.add(impactTableListDtl);
	        	System.out.println("ImpactTableDaoImpl :: impactTableList : impactTableListDtl "+impactTableListDtl);
	        }
	    } catch (Exception e) {
	    	System.out.println("ImpactTableDaoImpl :: impactTableList : exception");
	    	System.out.println("ImpactTableDaoImpl :: impactTableList : "+e.toString());	        
	    }
		return impactTableList;
	}
}
