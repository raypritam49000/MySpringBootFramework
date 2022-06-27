package com.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.model.Employee;
import com.rest.api.repository.EmployeeMyBatisRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeMyBatisRepository employeeMyBatisRepository;

	@Override
	public List<Employee> findAll() {
		return this.employeeMyBatisRepository.findAll();
	}

	@Override
	public Employee findById(long id) {
		return this.employeeMyBatisRepository.findById(id);
	}

	@Override
	public int deleteById(long id) {
		return this.employeeMyBatisRepository.deleteById(id);
	}

	@Override
	public int insert(Employee employee) {
		return this.employeeMyBatisRepository.insert(employee);
	}

	@Override
	public int update(Employee employee) {
		return this.employeeMyBatisRepository.update(employee);
	}

}
