package com.rest.api.services;

import java.util.List;

import com.rest.api.model.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(long id);
	public int deleteById(long id);
	public int insert(Employee employee);
	public int update(Employee employee);
}
