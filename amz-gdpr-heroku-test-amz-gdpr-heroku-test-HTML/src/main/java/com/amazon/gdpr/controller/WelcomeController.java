package com.amazon.gdpr.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Model model) {
		System.out.println("WelcomeController :: welcome : Executing welcome");
		//model.put("message", this.message);
		return "welcome";
	}
}