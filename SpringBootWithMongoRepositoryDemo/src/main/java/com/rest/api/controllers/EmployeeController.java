package com.rest.api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.entity.Employee;
import com.rest.api.services.EmployeeServices;

@RestController
@RequestMapping("/rest/api")
public class EmployeeController {

	@Autowired
	private EmployeeServices employeeServices;

	@PostMapping("/addEmployee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
		try {
			Boolean result = this.employeeServices.createEmployee(employee);
			if (result) {
				return ResponseEntity.ok(Map.of("message", "create employee successfully", "status", "200"));
			} else {
				return ResponseEntity.ok(Map.of("message", "create employee not successfully", "status", "502"));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message", e.getMessage(), "status", "502"));
		}

	}

	@GetMapping("/allEmployees")
	public ResponseEntity<?> getAllEmployees() {
		try {
			List<Employee> employees = this.employeeServices.getAllEmployees();
			if (employees != null && employees.size() > 0) {
				return ResponseEntity.ok(employees);
			} else {
				return ResponseEntity.ok(Map.of("message", "Data Not Found", "status", "404"));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message", e.getMessage(), "status", "502"));
		}

	}

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable("id") int id) {
		try {
			Employee employee = this.employeeServices.getEmployee(id);
			if (employee != null && !employee.getName().equals("")) {
				return ResponseEntity.ok(employee);
			} else {
				return ResponseEntity.ok(Map.of("message", "Data Not Found", "status", "404"));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message", e.getMessage(), "status", "502"));
		}

	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
		try {
			Boolean result = this.employeeServices.deleteEmployee(id);
			if (result) {
				return ResponseEntity.ok(Map.of("message", "Employee Data Deleted", "status", "203"));
			} else {
				return ResponseEntity.ok(Map.of("message", "Data Not Deleted", "status", "404"));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message", e.getMessage(), "status", "502"));
		}

	}
	
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee) {
		try {
			Boolean result = this.employeeServices.updateEmployee(id, employee);
			if (result) {
				return ResponseEntity.ok(Map.of("message", "Employee Data Update", "status", "201"));
			} else {
				return ResponseEntity.ok(Map.of("message", "Data Not Updated", "status", "404"));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message", e.getMessage(), "status", "502"));
		}

	}

}
