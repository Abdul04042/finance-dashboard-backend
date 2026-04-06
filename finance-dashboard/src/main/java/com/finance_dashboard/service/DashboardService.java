package com.finance_dashboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance_dashboard.model.FinancialRecord;

@Service
public class DashboardService {
	
	@Autowired
	private FinancialRecordService service;
	
	public Map<String, Object> getSummary(){
		List<FinancialRecord> records = service.getAllRecords();
		double income = records.stream().filter(r -> r.getType().equalsIgnoreCase("income"))
				.mapToDouble(FinancialRecord::getAmount).sum();
		double expense = records.stream().filter(r-> r.getType().equalsIgnoreCase("expense"))
				.mapToDouble(FinancialRecord::getAmount).sum();
		
		Map<String, Double> categoryTotals = new HashMap<>();
		for (FinancialRecord r : records) {
			categoryTotals.put(r.getCategory(),categoryTotals.getOrDefault(r.getCategory(),0.0)+ r.getAmount());
		}
		
		Map<String, Object> response = new HashMap<>();
		response.put("totalIncome", income);
		response.put("totalexpense", expense);
		response.put("netBalance", income - expense);
		response.put("categoryTotals", categoryTotals);
		
		return response;
	}

}
