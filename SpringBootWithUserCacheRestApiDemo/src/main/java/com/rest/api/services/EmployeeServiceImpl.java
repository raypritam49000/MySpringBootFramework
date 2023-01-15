package com.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.config.SimpleCacheManager;
import com.rest.api.entity.Employee;
import com.rest.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployee() {
		System.out.println("===>>> Find All Employee Data");
		SimpleCacheManager cacheManager = SimpleCacheManager.getInstance();
		if (cacheManager != null && cacheManager.isEmpty()) {
			List<Employee> employees = this.employeeRepository.findAll();
			cacheManager.put("employeeList", employees);
			return employees;
		} else {
			return (List<Employee>) cacheManager.get("employeeList");
		}
	}

	@Override
	public Employee findEmployeeById(int id) {
		System.out.println("===>>> Find Employee Data By Id");
		SimpleCacheManager cacheManager = SimpleCacheManager.getInstance();
		if (cacheManager != null && cacheManager.isEmpty()) {
			Employee employee = employeeRepository.findById(id).get();
			cacheManager.put("" + id, employee);
			return employee;
		} else {
			return (Employee) cacheManager.get("" + id);
		}

	}

	@Override
	public boolean deleteEmployeeById(int id) {
		System.out.println("===>>> Delete Employee Data By Id");
		Employee employee = this.employeeRepository.findById(id).get();
		SimpleCacheManager cacheManager = SimpleCacheManager.getInstance();
		if (employee != null) {
			this.employeeRepository.delete(employee);
			cacheManager.clear("" + id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEmployeeById(int id, Employee updateEmployee) {
		System.out.println("===>>> Update Employee Data By Id");
		SimpleCacheManager cacheManager = SimpleCacheManager.getInstance();
			
			Employee existingEmployee = this.employeeRepository.findById(id).get();
			if (existingEmployee != null) {
				existingEmployee.setName(updateEmployee.getName());
				existingEmployee.setCity(updateEmployee.getCity());
				existingEmployee.setSalary(updateEmployee.getSalary());
				Employee employeeDb = employeeRepository.save(existingEmployee);
				cacheManager.put(""+employeeDb.getId(), employeeDb);
				return true;
			}

		return false;
	}
	

	@Override
	public boolean createEmployee(Employee employee) {
		if (employee != null) {
			this.employeeRepository.save(employee);
			return true;
		}
		return false;
	}

}
