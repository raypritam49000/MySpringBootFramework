package com.techgeeknext.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techgeeknext.entities.company.Company;
import com.techgeeknext.entities.employee.Employee;
import com.techgeeknext.repository.company.CompanyRepository;
import com.techgeeknext.repository.employee.EmployeeRepository;

@RestController
@RequestMapping("/rest/api")
public class MyController {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/")
	public String hello() {
		System.out.println(companyRepository.findAll() + " " + employeeRepository.findAll());
		return "Hello Pritam Ray";
	}

	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		try {
			if (employee != null && !employee.getName().equals("")) {
				return ResponseEntity.ok(this.employeeRepository.save(employee));
			} else {
				return ResponseEntity.ok(Map.of("Message", "BAD_REQUEST", "Success", false));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("Message", e.getMessage(), "Success", false));
		}
	}
	

	@PostMapping("/addCompany")
	public ResponseEntity<?> addCompany(@RequestBody Company company) {
		System.out.println(company);
		try {
			if (company != null && !company.getName().equals("")) {
				return ResponseEntity.ok(this.companyRepository.save(company));
			} else {
				return ResponseEntity.ok(Map.of("Message", "BAD_REQUEST", "Success", false));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("Message", e.getMessage(), "Success", false));
		}
	}
	
	@GetMapping("/getAllCompanys")
	public ResponseEntity<?> getAllCompanys() {
		 List<Company> companys = this.companyRepository.findAll();
		try {
			if (companys != null && companys.size()>0) {
				return ResponseEntity.ok(companys);
			} else {
				return ResponseEntity.ok(Map.of("Message", "DATA_NOT_FOUND", "Success", false));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("Message", e.getMessage(), "Success", false));
		}
	}
	
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<?> getAllEmployees() {
		 List<Employee> employees = this.employeeRepository.findAll();
		try {
			if (employees != null && employees.size()>0) {
				return ResponseEntity.ok(employees);
			} else {
				return ResponseEntity.ok(Map.of("Message", "DATA_NOT_FOUND", "Success", false));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("Message", e.getMessage(), "Success", false));
		}
	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable("id") int id) {
		 Employee employee = this.employeeRepository.findById(id).get();
		try {
			if (employee != null && !employee.getName().equals("")) {
				return ResponseEntity.ok(employee);
			} else {
				return ResponseEntity.ok(Map.of("Message", "DATA_NOT_FOUND", "Success", false));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("Message", e.getMessage(), "Success", false));
		}
	}
	

	@GetMapping("/getCompany/{id}")
	public ResponseEntity<?> getCompany(@PathVariable("id") int id) {
		 Company company = this.companyRepository.findById(id).get();
		try {
			if (company != null && !company.getName().equals("")) {
				return ResponseEntity.ok(company);
			} else {
				return ResponseEntity.ok(Map.of("Message", "DATA_NOT_FOUND", "Success", false));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("Message", e.getMessage(), "Success", false));
		}
	}

}
