package com.rest.api.services;

import java.util.List;

import com.rest.api.entity.Employee;

public interface EmployeeServices {
	public abstract boolean createEmployee(Employee employee);
	public abstract List<Employee> getAllEmployees();
	public abstract Employee getEmployee(int id);
	public abstract boolean deleteEmployee(int id);
	public abstract boolean updateEmployee(int id,Employee employee);
}
