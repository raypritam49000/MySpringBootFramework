package com.database.join.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.database.join.api.entity.Employee;
import com.database.join.api.models.DeptEmpDto;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT new com.database.join.api.models.DeptEmpDto(d.name, e.name, e.email, e.address) FROM Department d INNER JOIN d.employees e")
	List<DeptEmpDto> fetchEmpDeptDataInnerJoin();

	@Query("SELECT new com.database.join.api.models.DeptEmpDto(d.name, e.name, e.email, e.address) FROM Department d, Employee e")
	List<DeptEmpDto> fetchEmpDeptDataCrossJoin();

}