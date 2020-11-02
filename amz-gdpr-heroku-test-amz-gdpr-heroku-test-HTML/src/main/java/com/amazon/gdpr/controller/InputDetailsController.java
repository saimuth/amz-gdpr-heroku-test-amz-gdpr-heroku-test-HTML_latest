package com.amazon.gdpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amazon.gdpr.service.DBAccessService;
import com.amazon.gdpr.view.InputDetailsVw;

@Controller
public class InputDetailsController {
	
	@RequestMapping("/inputDetails")
	public String inputDetails(Model model) {
		System.out.println("InputDetailsController :: inputDetails : Executing Input Details");
		InputDetailsVw view = DBAccessService.fetchInputDetails();
		model.addAttribute("users", view.userList);
		model.addAttribute("categories", view.categoryList);
		model.addAttribute("countryCode", view.countryCodeList);
		model.addAttribute("anonymization", view.anonymizationPattern);
		model.addAttribute("impactTable", view.impactTableList);
		model.addAttribute("impactField", view.impactFieldList);
		model.addAttribute("policyList", view.policyList);
		model.addAttribute("triggerReferenceList", view.triggerReferenceList);
		model.addAttribute("fieldAnonymizeMappingList", view.fieldAnonymizeMappingList);
		return "inputDetails";	
	}
}