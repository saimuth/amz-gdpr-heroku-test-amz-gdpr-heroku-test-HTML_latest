package com.amazon.gdpr.configuration;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfig {
	
	/* Todo Autowiring*/
	
	@Value("${spring.arch-datasource.url}")
	private String archDbUrl;
	
	@Value("${spring.gdpr-datasource.url}")
	private String gdprDbUrl;

	private Connection archDBConnection;
	private Connection gdprDBConnection;
		
	public DatabaseConfig() {
		try {
			System.out.println("DatabaseConfig :: DatabaseConfig : Establishing Archive DB Connection initiated");
			//archDbUrl = (archDbUrl == null)? System.getenv("DATABASE_URL") : archDbUrl;
			archDbUrl="postgres://ufvbetjvnfoa0k:pf58f94fc0f2581735051dbe88df44feda25c5e7cbf92f7762a2c6635aee511d8@ec2-34-235-212-19.compute-1.amazonaws.com:5432/d7p21nkiag9cur";

			archDBConnection = getDBConnection(archDbUrl);
			System.out.println("DatabaseConfig :: DatabaseConfig : Archive DB Connection extablished");
		}catch(Exception exception) {
			System.out.println("DatabaseConfig :: DatabaseConfig : Error in initializing archive DB connection");
		}	
		
		if(archDbUrl != gdprDbUrl) {
			
			try {
				System.out.println("DatabaseConfig :: DatabaseConfig : Establishing GDPR DB Connection initiated");
			//	gdprDbUrl = (gdprDbUrl == null) ? System.getenv("HEROKU_POSTGRESQL_ORANGE_URL") : gdprDbUrl;
				gdprDbUrl="postgres://udiuwsccckgwaq:1784838b81fad6417881e038d680fa80edc8fbe708ec91ea8878acd6f78888dc@ec2-54-224-124-241.compute-1.amazonaws.com:5432/d3h0ggs2lkolo1";
				gdprDBConnection = getDBConnection(gdprDbUrl);
				System.out.println("DatabaseConfig :: DatabaseConfig : GDPR DB Connection extablished");
			} catch (Exception exception) {
				System.out.println("DatabaseConfig :: DatabaseConfig : Error in initializing GDPR DB connection");
			}
			 
		}
		System.out.println("DatabaseConfig :: DatabaseConfig : Establishing DB Connection completed");
	}
	
	public Connection getArchiveDBConnection() throws URISyntaxException, SQLException {
		System.out.println("DatabaseConfig :: getArchiveDBConnection : Archive DB Connection");		
		return archDBConnection;
	}
	
	public Connection getGDPRDBConnection() throws URISyntaxException, SQLException {
		System.out.println("DatabaseConfig :: getGDPRDBConnection : GDPR DB Connection");
	    return (archDbUrl != gdprDbUrl)? gdprDBConnection : archDBConnection;
	}
	
	public Connection getDBConnection(String dbURL) throws URISyntaxException, SQLException {
		System.out.println("DatabaseConfig :: getDBConnection :  DB Connection");
		System.out.println("DatabaseConfig :: getDBConnection :  dbURL : "+dbURL);
        URI dbUri = null;
        if(dbURL != null) {
            dbUri = new URI(dbURL);
        }

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl1 = "jdbc:postgresql://" + dbUri.getHost() + ':'
                + dbUri.getPort() + dbUri.getPath()
                + "?sslmode=require";
/*		System.out.println("DatabaseConfig :: getDBConnection :  dbUrl1 : "+dbUrl1);
		System.out.println("DatabaseConfig :: getDBConnection :  username : "+username);
		System.out.println("DatabaseConfig :: getDBConnection :  password : "+password);*/
		return DriverManager.getConnection(dbUrl1, username, password);
	}
	
	public Connection getDBConnectiontest(String dbURL) throws URISyntaxException, SQLException {
		System.out.println("DatabaseConfig :: getDBConnection :  DB Connection");
		System.out.println("DatabaseConfig :: getDBConnection :  dbURL : "+dbURL);
		/*
		 * URI dbUri = null; if(dbURL != null) { dbUri = new URI(dbURL); }
		 */

		String username = "ufvbetjvnfoa0k";
		String password = "pf58f94fc0f2581735051dbe88df44feda25c5e7cbf92f7762a2c6635aee511d8";
		String dbUrl1 ="jdbc:postgresql://ec2-34-235-212-19.compute-1.amazonaws.com:5432/d7p21nkiag9cur";
/*		System.out.println("DatabaseConfig :: getDBConnection :  dbUrl1 : "+dbUrl1);
		System.out.println("DatabaseConfig :: getDBConnection :  username : "+username);
		System.out.println("DatabaseConfig :: getDBConnection :  password : "+password);*/
		return DriverManager.getConnection(dbUrl1, username, password);
	}
}