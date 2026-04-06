package com.finance_dashboard.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finance_dashboard.model.FinancialRecord;
import com.finance_dashboard.model.Role;
import com.finance_dashboard.service.FinancialRecordService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {
	
	@Autowired
	private FinancialRecordService service;

		
	@GetMapping("/public")
	public ResponseEntity<List<FinancialRecord>> getAllRecords(){
		
		List<FinancialRecord> records = service.getAllRecords();
		
		return new ResponseEntity<>(records,HttpStatus.OK);
		
	}
	@GetMapping("/type/{type}")
	public ResponseEntity<List<FinancialRecord>> getByType(@PathVariable String type){
	    return ResponseEntity.ok(service.getRecordsByType(type));
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<List<FinancialRecord>> getByCategory(@PathVariable String category){
	    return ResponseEntity.ok(service.getRecordsByCategory(category));
	}
	
	@PostMapping("/public")
	public ResponseEntity<String> createRecord(@Valid @RequestBody FinancialRecord record, @RequestHeader("Role") Role role){
		if(role == Role.VIEWER) {
			return ResponseEntity.status(403).body("Access denied");
		}
		service.createRecord(record);
		return new ResponseEntity<>("Record Created",HttpStatus.OK);
		
	}
	
	@PutMapping("/admin/{id}")
	public ResponseEntity<String> updateRecord(@RequestBody FinancialRecord  record, @PathVariable Long id  ,@RequestHeader("Role") Role role){
		if (role != Role.ADMIN) {
			return ResponseEntity.status(403).body("only ADMIN allowed");
		}
		service.updateRecord(id ,record);
		return new ResponseEntity<>("Record updated",HttpStatus.OK);
	}
	@DeleteMapping("/admin/{id}")
	public ResponseEntity<String> deleteRecord(@PathVariable Long id){
		service.deleteRecord(id);
		
		return new ResponseEntity<> ("Record deleted", HttpStatus.OK);
	}

	@GetMapping("/dashboard/summary")
	public ResponseEntity<Map<String, Double>> getSummary(){
	    return ResponseEntity.ok(service.getDashboardSummary());
	}
}
