package com.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.model.Employee;
import com.rest.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee findById(long id) {
		return this.employeeRepository.findById(id);
	}

	@Override
	public int deleteById(long id) {
		return this.employeeRepository.deleteById(id);
	}

	@Override
	public int insert(Employee employee) {
		return this.employeeRepository.insert(employee);
	}

	@Override
	public int update(Employee employee) {
		return this.employeeRepository.update(employee);
	}

}
