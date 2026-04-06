package com.finance_dashboard.service;

import java.util.List;
import java.util.Map;
import com.finance_dashboard.model.FinancialRecord;

public interface FinancialRecordService {
	
	List<FinancialRecord> getAllRecords();
	
	List<FinancialRecord> getRecordsByType(String type);

	List<FinancialRecord> getRecordsByCategory(String category);
	
	void createRecord(FinancialRecord record);
	
	void deleteRecord(Long id);

	void updateRecord(Long id,FinancialRecord record);

	Map<String, Double> getDashboardSummary();

	
}
