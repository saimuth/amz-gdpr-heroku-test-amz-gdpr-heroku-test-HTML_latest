package com.amazon.gdpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amazon.gdpr.service.HerokuConnectService;
import com.amazon.gdpr.view.SalesforceDetailsVw;

@Controller
public class SalesforceDetailsController {
	@RequestMapping("/salesforceDetails")
	public String salesforceDetails(Model model) {
		System.out.println("SalesforceDetailsController :: salesforceDetails : Executing Salesforce Details");
		SalesforceDetailsVw view = HerokuConnectService.fetchSalesforceDetails();
		model.addAttribute("company", view.countryMappingList);
		return "salesforceDetails";	
	}
}
