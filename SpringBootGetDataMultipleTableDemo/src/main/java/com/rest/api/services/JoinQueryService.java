package com.rest.api.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rest.api.dto.DeptEmpDto;
import com.rest.api.entity.Employee;
import com.rest.api.repositories.DepartmentRepository;
import com.rest.api.repositories.EmployeeRepository;

@Service
public class JoinQueryService {

	@Resource
	private DepartmentRepository departmentRepository;

	@Resource
	private EmployeeRepository employeeRepository;

	public List<DeptEmpDto> getDeptEmployeesLeftJoin() {
		List<DeptEmpDto> list = departmentRepository.fetchEmpDeptDataLeftJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

	public List<DeptEmpDto> getDeptEmployeesRightJoin() {
		List<DeptEmpDto> list = departmentRepository.fetchEmpDeptDataRightJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

	public List<DeptEmpDto> getDeptEmployeesInnerJoin() {
		List<DeptEmpDto> list = employeeRepository.fetchEmpDeptDataInnerJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

	public List<DeptEmpDto> getDeptEmployeesCrossJoin() {
		List<DeptEmpDto> list = employeeRepository.fetchEmpDeptDataCrossJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}
	
	public List<DeptEmpDto> findAllWithDeptEmpDetailsQuery(){
		List<DeptEmpDto> list = employeeRepository.findAllWithDeptEmpDetailsQuery();
		list.forEach(l -> System.out.println(l));
		return list;
	}
	
	public List<DeptEmpDto> findAllWithDeptEmpDetailsRightJoin(){
		List<DeptEmpDto> list = employeeRepository.findAllWithDeptEmpDetailsRightJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}
	
	public Employee findEmployeeByDepartmentId(long id){
		
		Employee employee = null;
		List<Object[]> objects = employeeRepository.findEmployeeByDepartmentId(id);
		
		for (Object[] object : objects) {
			String name = (String) object[0];
			String email = (String) object[1];
			String mobile = (String) object[2];
			employee = new Employee(name, email, mobile);
		}
		
		return employee;
	}

}