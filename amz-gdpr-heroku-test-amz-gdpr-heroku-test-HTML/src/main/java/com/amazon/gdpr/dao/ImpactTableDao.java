package com.amazon.gdpr.dao;

import java.util.List;

import com.amazon.gdpr.model.Category;
import com.amazon.gdpr.model.ImpactTable;

public interface ImpactTableDao {
	public List<ImpactTable> impactTableList();
}
