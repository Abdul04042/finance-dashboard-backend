package com.finance_dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance_dashboard.model.FinancialRecord;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord,Long> {
	List<FinancialRecord> findByType(String type);

    List<FinancialRecord> findByCategory(String category);
}
