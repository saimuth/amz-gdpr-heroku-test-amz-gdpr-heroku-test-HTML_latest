package com.amazon.gdpr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amazon.gdpr.configuration.DatabaseConfig;
import com.amazon.gdpr.model.Category;
import com.amazon.gdpr.model.Policy;

public class PolicyDaoImpl implements PolicyDao{
	private Statement stmt;
	public PolicyDaoImpl() {
		System.out.println("PolicyDaoImpl :: PolicyDaoImpl : Connection establishment");
		try {
			Connection connection = new DatabaseConfig().getArchiveDBConnection();
	        stmt = connection.createStatement();
		}catch (Exception e) {
	    	System.out.println("PolicyDaoImpl :: PolicyDaoImpl : Connection exception");
	    	System.out.println("PolicyDaoImpl :: PolicyDaoImpl : "+e.toString());	        
	    }
	}
	


	@Override
	public List<Policy> policyList() {
		System.out.println("PolicyDaoImpl :: policyList : started");
		List<Policy> policyList = null;
		try {	        
	        String sql = "SELECT * FROM heroku_depersonalisation.policy";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        System.out.println("PolicyDaoImpl :: policyList : Fetched the resultset"+rs.getFetchSize());
	        policyList = new ArrayList<Policy>();
	        while (rs.next()) {
	        	Policy policyDtl = new Policy();
	       
	        	policyDtl.setPolicy_ID(rs.getInt("policy_id"));
	        	policyDtl.setCategory_Id(rs.getInt("category_id"));
	        	policyDtl.setCountry_Code(rs.getString("country_code"));
	        	policyDtl.setCountry_Id(rs.getInt("country_id"));
	        	policyDtl.setPolicy_Criterion(rs.getString("policy_criterion"));
	        	policyDtl.setStatus(rs.getString("status"));
	        	policyDtl.setDepersonalization_Condition(rs.getString("depersonalization_condition"));
	        
	        		        	
	        	policyList.add(policyDtl);
				System.out.println("PolicyDaoImpl :: policyList : policyDtl "+policyDtl);
	        }
	        //model.addAttribute("users", users);	        
	    } catch (Exception e) {
	    	System.out.println("PolicyDaoImpl :: policyList : exception");
	    	System.out.println("PolicyDaoImpl :: policyList : "+e.toString());	        
	    }
		return policyList;
	}
}