package com.rest.api.controller;

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

import com.rest.api.model.Employee;
import com.rest.api.services.EmployeeService;

@RestController
@RequestMapping("/rest/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployees")
	public ResponseEntity<?> getAllEmployees() {

		try {
			List<Employee> employees = this.employeeService.findAll();

			if (employees.size() > 0 && employees != null) {
				return ResponseEntity
						.ok(Map.of("message", "List Employees", "body", employees, "status", 200, "success", true));
			} else {
				return ResponseEntity
						.ok(Map.of("message", "Data Not Found", "body", employees, "status", 404, "success", false));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message", e.getMessage(), "status", 502, "success", false));
		}

	}

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable("id") long id) {

		try {
			Employee employee = this.employeeService.findById(id);

			if (employee != null && !employee.getName().equals("") && !employee.getSalary().equals("")
					&& !employee.getSalary().equals("")) {
				return ResponseEntity
						.ok(Map.of("message", "List Employees", "body", employee, "status", 200, "success", true));
			} else {
				return ResponseEntity
						.ok(Map.of("message", "Data Not Found", "body", employee, "status", 404, "success", false));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message", e.getMessage(), "status", 502, "success", false));
		}

	}

	@PostMapping("/createEmployee")
	public ResponseEntity<?> getEmployee(@RequestBody Employee employee) {

		try {
			if (employee != null && !employee.getName().equals("") && !employee.getSalary().equals("")
					&& !employee.getSalary().equals("")) {

				int result = this.employeeService.insert(employee);

				if (result > 0) {
					return ResponseEntity.ok(Map.of("message", "Create Employee", "status", 201, "success", true));
				} else {
					return ResponseEntity.ok(Map.of("message", "Not Create Employee", "status", 404, "success", false));
				}
			} else {
				return ResponseEntity.ok(Map.of("message", "BAD_REQUEST_GATEWAY", "status", 502, "success", false));
			}

		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message", e.getMessage(), "status", 502, "success", false));
		}

	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id) {

		try {

			int result = this.employeeService.deleteById(id);

			if (result > 0) {
				return ResponseEntity.ok(Map.of("message", "Deleted Employee", "status", 204, "success", true));
			} else {
				return ResponseEntity.ok(Map.of("message", "Not Delete Employee", "status", 501, "success", false));
			}

		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message", e.getMessage(), "status", 502, "success", false));
		}

	}

	@PutMapping("/updateEmployee")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		try {

			int result = this.employeeService.update(employee);
			System.out.println(result);

			if (result > 0) {
				return ResponseEntity.ok(Map.of("message", "Update Employee", "status", 202, "success", true));
			} else {
				return ResponseEntity.ok(Map.of("message", "Not Update Employee", "status", 501, "success", false));
			}

		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message", e.getMessage(), "status", 502, "success", false));
		}

	}
}
