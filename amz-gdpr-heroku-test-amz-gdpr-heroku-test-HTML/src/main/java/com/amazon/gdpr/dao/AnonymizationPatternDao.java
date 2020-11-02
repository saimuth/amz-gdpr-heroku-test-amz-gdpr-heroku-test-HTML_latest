package com.amazon.gdpr.dao;

import java.util.List;

import com.amazon.gdpr.model.AnonymizationPattern;
import com.amazon.gdpr.model.CountryCode;
import com.amazon.gdpr.model.CountryMapping;

public interface AnonymizationPatternDao {
	public List<AnonymizationPattern> AnonymizationPatternList();
}
