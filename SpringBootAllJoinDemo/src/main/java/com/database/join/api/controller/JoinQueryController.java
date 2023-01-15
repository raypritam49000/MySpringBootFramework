package com.database.join.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.join.api.models.DeptEmpDto;
import com.database.join.api.services.JoinQueryService;

@RestController
@RequestMapping("/rest/api")
public class JoinQueryController {

	@Autowired
	private JoinQueryService joinQueryService;

	@GetMapping("/dept/employees/left")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesLeftJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesLeftJoin(), HttpStatus.OK);
	}

	@GetMapping("/dept/employees/right")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesRightJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesRightJoin(), HttpStatus.OK);
	}

	@GetMapping("/dept/employees/inner")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesInnerJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesInnerJoin(), HttpStatus.OK);
	}

	@GetMapping("/dept/employees/cross")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesCrossJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesCrossJoin(), HttpStatus.OK);
	}
	
	@GetMapping("/dept/employees/cross/{id}")
	public ResponseEntity<List<DeptEmpDto>> fetchEmpDeptDataLeftJoinById(@PathVariable("id") int id) {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.fetchEmpDeptDataLeftJoinById(id), HttpStatus.OK);
	}

}