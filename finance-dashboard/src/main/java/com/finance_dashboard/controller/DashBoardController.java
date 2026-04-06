package com.finance_dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance_dashboard.model.Role;
import com.finance_dashboard.service.DashboardService;


@RestController
@RequestMapping("/api/dashboard")
public class DashBoardController {
	
	@Autowired
	private DashboardService service;
	
	@GetMapping
	public ResponseEntity<?> getDashboard(@RequestHeader Role role){
		return ResponseEntity.ok(service.getSummary());
	}

}
