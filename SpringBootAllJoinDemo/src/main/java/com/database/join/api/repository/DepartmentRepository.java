package com.database.join.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.database.join.api.entity.Department;
import com.database.join.api.models.DeptEmpDto;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	@Query("SELECT new com.database.join.api.models.DeptEmpDto(d.name, e.name, e.email, e.address) FROM Department d LEFT JOIN d.employees e")
	List<DeptEmpDto> fetchEmpDeptDataLeftJoin();

	@Query("SELECT new com.database.join.api.models.DeptEmpDto(d.name, e.name, e.email, e.address) FROM Department d RIGHT JOIN d.employees e")
	List<DeptEmpDto> fetchEmpDeptDataRightJoin();
	
	@Query("SELECT new com.database.join.api.models.DeptEmpDto(d.name, e.name, e.email, e.address) FROM Department d LEFT JOIN d.employees e ON e.id =:id ")
	List<DeptEmpDto> fetchEmpDeptDataLeftJoinById(@Param("id") int id);

}