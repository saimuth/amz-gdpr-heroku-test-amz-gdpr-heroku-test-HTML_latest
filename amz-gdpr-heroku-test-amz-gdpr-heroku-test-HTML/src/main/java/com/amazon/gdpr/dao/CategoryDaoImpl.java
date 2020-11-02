package com.amazon.gdpr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amazon.gdpr.configuration.DatabaseConfig;
import com.amazon.gdpr.model.Category;

public class CategoryDaoImpl implements CategoryDao{
	private Statement stmt;
	public CategoryDaoImpl() {
		System.out.println("CategoryDaoImpl :: CategoryDaoImpl : Connection establishment");
		try {
			Connection connection = new DatabaseConfig().getArchiveDBConnection();
	        stmt = connection.createStatement();
		}catch (Exception e) {
	    	System.out.println("CategoryDaoImpl :: CategoryDaoImpl : Connection exception");
	    	System.out.println("CategoryDaoImpl :: CategoryDaoImpl : "+e.toString());	        
	    }
	}
	
	@Override
	public List<Category> categoryList() {
		System.out.println("CategoryDaoImpl :: categoryList : started");
		List<Category> categoryList = null;
		try {	        
	        String sql = "SELECT * FROM heroku_depersonalisation.category";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        System.out.println("CategoryDaoImpl :: categoryList : Fetched the resultset"+rs.getFetchSize());
	        categoryList = new ArrayList<Category>();
	        while (rs.next()) {
	        	Category categoryDtl = new Category();
	        	
	        	categoryDtl.setCategoryId(rs.getInt("Category_id"));
	        	categoryDtl.setCategoryName(rs.getString("Category_Name"));
	        	categoryDtl.setStatus(rs.getString("Status"));
	        		        	
				categoryList.add(categoryDtl);
				System.out.println("CategoryDaoImpl :: categoryList : categoryDtl "+categoryDtl);
	        }
	        //model.addAttribute("users", users);	        
	    } catch (Exception e) {
	    	System.out.println("CategoryDaoImpl :: categoryList : exception");
	    	System.out.println("CategoryDaoImpl :: categoryList : "+e.toString());	        
	    }
		return categoryList;
	}
}