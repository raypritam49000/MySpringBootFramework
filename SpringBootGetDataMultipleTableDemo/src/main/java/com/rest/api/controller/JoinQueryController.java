package com.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.dto.DeptEmpDto;
import com.rest.api.entity.Employee;
import com.rest.api.services.JoinQueryService;

@RestController
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
	
	@GetMapping("/dept/employees/leftId")
	public ResponseEntity<List<DeptEmpDto>> findAllWithDeptEmpDetailsQuery() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.findAllWithDeptEmpDetailsQuery(), HttpStatus.OK);
	}
	
	@GetMapping("/dept/employees/rightId")
	public ResponseEntity<List<DeptEmpDto>> findAllWithDeptEmpDetailsRightJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.findAllWithDeptEmpDetailsRightJoin(), HttpStatus.OK);
	}
	
	@GetMapping("/dept/employees/join/{id}")
	public ResponseEntity<Employee> findEmployeeByDepartmentId(@PathVariable("id") long id) {
		Employee employee = joinQueryService.findEmployeeByDepartmentId(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	

}