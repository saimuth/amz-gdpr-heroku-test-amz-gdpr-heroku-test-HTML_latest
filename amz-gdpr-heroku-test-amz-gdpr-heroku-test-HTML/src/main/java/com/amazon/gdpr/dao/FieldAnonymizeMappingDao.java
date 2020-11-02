package com.amazon.gdpr.dao;

import java.util.List;

import com.amazon.gdpr.model.Category;
import com.amazon.gdpr.model.FieldAnonymizeMapping;
import com.amazon.gdpr.model.ImpactField;

public interface FieldAnonymizeMappingDao {
	public List<FieldAnonymizeMapping> fieldAnonymizeMappingList();
}
