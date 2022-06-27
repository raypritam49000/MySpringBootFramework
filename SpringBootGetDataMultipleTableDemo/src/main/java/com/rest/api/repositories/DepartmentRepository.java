package com.rest.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.api.dto.DeptEmpDto;
import com.rest.api.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	@Query("SELECT new com.rest.api.dto.DeptEmpDto(d.name, e.name, e.email, e.address) FROM Department d LEFT JOIN d.employees e")
	public abstract List<DeptEmpDto> fetchEmpDeptDataLeftJoin();

	@Query("SELECT new com.rest.api.dto.DeptEmpDto(d.name, e.name, e.email, e.address) FROM Department d RIGHT JOIN d.employees e")
	public abstract List<DeptEmpDto> fetchEmpDeptDataRightJoin();

}