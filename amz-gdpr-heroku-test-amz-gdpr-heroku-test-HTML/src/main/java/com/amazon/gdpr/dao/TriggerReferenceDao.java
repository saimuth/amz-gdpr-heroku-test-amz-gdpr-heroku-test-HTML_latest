package com.amazon.gdpr.dao;

import java.util.List;

import com.amazon.gdpr.model.Category;
import com.amazon.gdpr.model.TriggerReference;

public interface TriggerReferenceDao {
	public List<TriggerReference> triggerReferenceList();
}
