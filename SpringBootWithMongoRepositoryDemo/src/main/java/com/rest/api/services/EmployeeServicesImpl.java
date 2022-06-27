package com.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.entity.Employee;
import com.rest.api.entity.NextSequenceService;
import com.rest.api.repository.EmployeeRepository;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private  NextSequenceService nextSequenceService;

	@Override
	public boolean createEmployee(Employee employee) {
		
		employee.setId(nextSequenceService.getNextSequence("customSequences"));
		Employee employeedb = this.employeeRepository.save(employee);
		if (employeedb != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(int id) {
		return this.employeeRepository.findById(id).get();
	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee employee =  this.employeeRepository.findById(id).get();
		if(employee!=null) {
			this.employeeRepository.delete(employee);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEmployee(int id, Employee updateEmployee) {
		Employee exitsEmployee =  this.employeeRepository.findById(id).get();
		if(exitsEmployee!=null) {
			exitsEmployee.setCity(updateEmployee.getCity());
			exitsEmployee.setName(updateEmployee.getName());
			exitsEmployee.setSalary(updateEmployee.getSalary());
			this.employeeRepository.save(exitsEmployee);
			return true;
		}
		return false;
	}

}
