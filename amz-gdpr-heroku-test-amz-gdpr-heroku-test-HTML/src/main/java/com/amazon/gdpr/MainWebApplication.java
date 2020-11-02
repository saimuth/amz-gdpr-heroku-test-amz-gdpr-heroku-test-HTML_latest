package com.amazon.gdpr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MainWebApplication extends SpringBootServletInitializer {	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("MainWebApplication :: configure : Executing configure");
		setRegisterErrorPageFilter(false);
		return application.sources(MainWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("MainWebApplication :: main : Executing main");
		SpringApplication.run(MainWebApplication.class, args);
	}
	
}