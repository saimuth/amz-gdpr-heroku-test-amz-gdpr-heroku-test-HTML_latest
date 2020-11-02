package com.amazon.gdpr.dao;

import java.util.List;

import com.amazon.gdpr.model.Category;
import com.amazon.gdpr.model.ImpactField;

public interface ImpactFieldDao {
	public List<ImpactField> impactFieldList();
}
