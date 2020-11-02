package com.amazon.gdpr.dao;

import java.util.List;

import com.amazon.gdpr.model.Category;
import com.amazon.gdpr.model.Policy;

public interface PolicyDao {
	public List<Policy> policyList();
}
