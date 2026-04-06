package com.finance_dashboard.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance_dashboard.model.FinancialRecord;
import com.finance_dashboard.repositories.FinancialRecordRepository;

@Service
public class FinancialRecordServiceImpl implements FinancialRecordService {

    @Autowired
    private FinancialRecordRepository repository;

    @Override
    public List<FinancialRecord> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public void createRecord(FinancialRecord record) {
        repository.save(record);
    }

    @Override
    public void updateRecord(Long id, FinancialRecord record) {

        FinancialRecord record1 = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record1.setAmount(record.getAmount());
        record1.setType(record.getType());
        record1.setCategory(record.getCategory());
        record1.setDate(record.getDate());
        record1.setNotes(record.getNotes());

        repository.save(record1);
    }

    @Override
    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }
    
    @Override
    public List<FinancialRecord> getRecordsByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public List<FinancialRecord> getRecordsByCategory(String category) {
        return repository.findByCategory(category);
    }
    @Override
    public Map<String, Double> getDashboardSummary(){

        List<FinancialRecord> records = repository.findAll();

        double income = 0;
        double expense = 0;

        for(FinancialRecord r : records){

            if("INCOME".equalsIgnoreCase(r.getType())){
                income += r.getAmount();
            }

            if("EXPENSE".equalsIgnoreCase(r.getType())){
                expense += r.getAmount();
            }

        }

        Map<String, Double> summary = new HashMap<>();

        summary.put("Total Income", income);
        summary.put("Total Expense", expense);
        summary.put("Net Balance", income - expense);

        return summary;
    }
}