package com.rest.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.api.dto.DeptEmpDto;
import com.rest.api.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(value="SELECT e.name, e.email, e.address FROM Employee e JOIN e.department d where d.id =:id")
	public abstract  List<Object[]> findEmployeeByDepartmentId(@Param("id") long id);

	@Query("SELECT new com.rest.api.dto.DeptEmpDto(d.name, e.name, e.email, e.address) FROM Department d INNER JOIN d.employees e")
	public abstract List<DeptEmpDto> fetchEmpDeptDataInnerJoin();

	@Query("SELECT new com.rest.api.dto.DeptEmpDto(d.name, e.name, e.email, e.address) FROM Department d, Employee e")
	public abstract List<DeptEmpDto> fetchEmpDeptDataCrossJoin();
	
	@Query("SELECT new com.rest.api.dto.DeptEmpDto(d.name, e.name, e.email, e.address) From Department d  left join Employee e on d.id = e.id")
	public abstract List<DeptEmpDto> findAllWithDeptEmpDetailsQuery();
	
	@Query("SELECT new com.rest.api.dto.DeptEmpDto(d.name, e.name, e.email, e.address) From Department d  Right join Employee e on d.id = e.id")
	public abstract List<DeptEmpDto> findAllWithDeptEmpDetailsRightJoin();

}