package com.amazon.gdpr.view;

import java.util.List;

import com.amazon.gdpr.dao.ImpactTableDaoImpl;
import com.amazon.gdpr.model.AnonymizationPattern;
import com.amazon.gdpr.model.Category;
import com.amazon.gdpr.model.CountryCode;
import com.amazon.gdpr.model.FieldAnonymizeMapping;
import com.amazon.gdpr.model.ImpactField;
import com.amazon.gdpr.model.ImpactTable;
import com.amazon.gdpr.model.Policy;
import com.amazon.gdpr.model.TriggerReference;
import com.amazon.gdpr.model.User;

public class InputDetailsVw {
	public List<User> userList;
	public List<Category> categoryList;
	public List<CountryCode> countryCodeList;
	public List<AnonymizationPattern> anonymizationPattern;
	public List<ImpactTable> impactTableList ;
	public List<ImpactField> impactFieldList;
	public List<Policy> policyList ;
	public List<TriggerReference>  triggerReferenceList;
	public List<FieldAnonymizeMapping> fieldAnonymizeMappingList;
	public InputDetailsVw(List<User> userList, List<Category> categoryList,List<CountryCode> countryCodeList,
			List<AnonymizationPattern> anonymizationPattern,
			List<ImpactTable> impactTableList, List<ImpactField> impactFieldList,
			List<Policy> policyList,List<TriggerReference>  triggerReferenceList,List<FieldAnonymizeMapping> fieldAnonymizeMappingList ) {
		super();
		this.userList = userList;
		this.categoryList = categoryList;
		this.countryCodeList = countryCodeList;
		this.anonymizationPattern=anonymizationPattern;
		this.impactTableList = impactTableList;
		this.impactFieldList = impactFieldList;
		this.policyList=policyList;
		this.triggerReferenceList =triggerReferenceList;
		this.fieldAnonymizeMappingList=fieldAnonymizeMappingList;
	}
}