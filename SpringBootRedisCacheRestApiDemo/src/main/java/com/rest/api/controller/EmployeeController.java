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

import com.rest.api.entity.Employee;
import com.rest.api.services.EmployeeService;

@RestController
@RequestMapping("/rest/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/createEmployee")
	public ResponseEntity<?> getEmployee(@RequestBody Employee employee) {

		try {
			if (employee != null && !employee.getName().equals("") && !employee.getSalary().equals("")
					&& !employee.getSalary().equals("")) {

				Boolean result = this.employeeService.createEmployee(employee);

				if (result) {
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

	@GetMapping("/getAllEmployees")
	public ResponseEntity<?> getAllEmployees() {

		try {
			List<Employee> employees = this.employeeService.findAllEmployee();

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
	public ResponseEntity<?> getEmployee(@PathVariable("id") int id) {

		try {
			Employee employee = this.employeeService.findEmployeeById(id);

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

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {

		try {
			boolean result = this.employeeService.deleteEmployeeById(id);
			if (result) {
				return ResponseEntity.ok(Map.of("message", "Deleted Employee", "status", 204, "success", true));
			} else {
				return ResponseEntity.ok(Map.of("message", "Not Delete Employee", "status", 501, "success", false));
			}

		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message", e.getMessage(), "status", 502, "success", false));
		}

	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		System.out.println(employee);
		try {

			Boolean result = this.employeeService.updateEmployeeById(id, employee);
			System.out.println(result);

			if (result) {
				return ResponseEntity.ok(Map.of("message", "Update Employee", "status", 202, "success", true));
			} else {
				return ResponseEntity.ok(Map.of("message", "Not Update Employee", "status", 501, "success", false));
			}

		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message", e.getMessage(), "status", 502, "success", false));
		}

	}

}

   

