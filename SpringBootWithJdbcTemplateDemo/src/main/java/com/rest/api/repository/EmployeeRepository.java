package com.rest.api.repository;

import java.util.List;

import com.rest.api.model.Employee;

public interface EmployeeRepository {
	public List<Employee> findAll();
	public Employee findById(long id);
	public int deleteById(long id);
	public int insert(Employee employee);
	public int update(Employee employee);
}