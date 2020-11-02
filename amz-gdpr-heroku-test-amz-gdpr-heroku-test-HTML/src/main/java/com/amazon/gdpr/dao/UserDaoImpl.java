package com.amazon.gdpr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amazon.gdpr.configuration.DatabaseConfig;
import com.amazon.gdpr.model.User;

public class UserDaoImpl implements UserDao{
	
	/*private JdbcTemplate jdbcTemp;

	public UserDaoImpl(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}*/
	
	private Statement stmt;
	public UserDaoImpl() {
		System.out.println("UserDaoImpl :: UserDaoImpl : Connection establishment");
		try {
			Connection connection = new DatabaseConfig().getArchiveDBConnection();
	        stmt = connection.createStatement();
		}catch (Exception e) {
	    	System.out.println("UserDaoImpl :: UserDaoImpl : Connection exception");
	    	System.out.println("UserDaoImpl :: UserDaoImpl : "+e.toString());	        
	    }
	}
	
	@Override
	public List<User> userList() {
		System.out.println("UserDaoImpl :: userList : started");
		List<User> userList = null;
		try {	        
	        String sql = "SELECT * FROM sf_archived.User LIMIT 10";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        System.out.println("UserDaoImpl :: userList : Fetched the resultset"+rs.getFetchSize());
	        userList = new ArrayList<User>();
	        while (rs.next()) {
	        	User userDtl = new User();

				userDtl.setId(rs.getLong("Id"));
				userDtl.setSfid(rs.getString("sfid"));
				userDtl.setName(rs.getString("Name"));
				userDtl.setAlias(rs.getString("Alias"));
				userDtl.setUsername(rs.getString("Username"));
				userDtl.setCreatedDate(rs.getTimestamp("CreatedDate"));
				userDtl.setSystemmodstamp(rs.getTimestamp("systemmodstamp"));
				userList.add(userDtl);
				System.out.println("DBAccessService :: userList : UserDtl"+userDtl);
	        }
	        //model.addAttribute("users", users);	        
	    } catch (Exception e) {
	    	System.out.println("UserDaoImpl :: userList : exception");
	    	System.out.println("UserDaoImpl :: userList : "+e.toString());	        
	    }
		return userList;
		
		/*List<User> list = jdbcTemp.query("SELECT * FROM User", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User userDtl = new User();

				userDtl.setId(rs.getLong("Id"));
				userDtl.setSfid(rs.getString("sfid"));
				userDtl.setName(rs.getString("Name"));
				userDtl.setAlias(rs.getString("Alias"));
				userDtl.setUsername(rs.getString("Username"));
				userDtl.setCreatedDate(rs.getTimestamp("CreatedDate"));
				userDtl.setSystemmodstamp(rs.getTimestamp("systemmodstamp"));
				
				return userDtl;
			}
		});
		return list;*/
	}	
}