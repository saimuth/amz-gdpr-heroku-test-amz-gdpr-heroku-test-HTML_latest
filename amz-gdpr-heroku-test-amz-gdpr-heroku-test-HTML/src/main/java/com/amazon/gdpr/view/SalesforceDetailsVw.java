package com.amazon.gdpr.view;

import java.util.List;

import com.amazon.gdpr.model.CountryMapping;

public class SalesforceDetailsVw {
	public List<CountryMapping> countryMappingList;
	
	public SalesforceDetailsVw(List<CountryMapping> countryMappingList) {
		super();
		this.countryMappingList = countryMappingList;
	}
}
