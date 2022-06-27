package com.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rest.api.entity.Employee;
import com.rest.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Cacheable(value = "employeeCache")
	@Override
	public List<Employee> findAllEmployee() {
		System.out.println("===>>> Find All Employee Data");
		return this.employeeRepository.findAll();
	}

	@Cacheable(value = "employeeCache", key = "#id")
	@Override
	public Employee findEmployeeById(int id) {
		System.out.println("===>>> Find Employee Data By Id");
		return this.employeeRepository.findById(id).get();
	}

	@CacheEvict(value = "employeeCache", key = "#id")
	@Override
	public boolean deleteEmployeeById(int id) {
		System.out.println("===>>> Delete Employee Data By Id");
		Employee employee = this.employeeRepository.findById(id).get();
		if (employee != null) {
			this.employeeRepository.delete(employee);
			return true;
		}
		return false;
	}

	@CachePut(value = "employeeCache", key = "#id")
	@Override
	public boolean updateEmployeeById(int id, Employee updateEmployee) {
		System.out.println("===>>> Update Employee Data By Id");
		Employee existingEmployee = this.employeeRepository.findById(id).get();
		if (existingEmployee != null) {
			existingEmployee.setName(updateEmployee.getName());
			existingEmployee.setCity(updateEmployee.getCity());
			existingEmployee.setSalary(updateEmployee.getSalary());
			this.employeeRepository.save(existingEmployee);
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
