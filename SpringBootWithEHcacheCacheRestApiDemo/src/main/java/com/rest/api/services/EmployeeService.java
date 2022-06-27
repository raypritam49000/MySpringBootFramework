package com.rest.api.services;

import java.util.List;

import com.rest.api.entity.Employee;

public interface EmployeeService {
	public abstract List<Employee> findAllEmployee();

	public abstract Employee findEmployeeById(int id);

	public abstract boolean deleteEmployeeById(int id);

	public abstract boolean updateEmployeeById(int id, Employee employee);
	
	public abstract boolean createEmployee(Employee employee);
	
}
