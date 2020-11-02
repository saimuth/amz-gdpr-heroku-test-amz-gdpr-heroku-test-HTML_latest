package com.amazon.gdpr.service;

import java.util.List;

import com.amazon.gdpr.dao.CountryMappingDaoImpl;
import com.amazon.gdpr.model.CountryMapping;
import com.amazon.gdpr.view.SalesforceDetailsVw;

public class HerokuConnectService {
	
	public static SalesforceDetailsVw fetchSalesforceDetails() {
		System.out.println("DBAccessService :: fetchUserDetails : Inside Service Details");
		List<CountryMapping> countryList = new CountryMappingDaoImpl().countryMappingList();
		return new SalesforceDetailsVw(countryList);
	}
}
