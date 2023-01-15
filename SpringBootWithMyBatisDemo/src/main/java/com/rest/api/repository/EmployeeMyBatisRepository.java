package com.rest.api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rest.api.model.Employee;

@Mapper
public interface EmployeeMyBatisRepository {

	@Select("select * from employees")
	public List<Employee> findAll();

	@Select("SELECT * FROM employees WHERE id = #{id}")
	public Employee findById(long id);

	@Delete("DELETE FROM employees WHERE id = #{id}")
	public int deleteById(long id);

	@Insert("INSERT INTO employees(id, name, city,salary) VALUES (#{id}, #{name}, #{city}, #{salary})")
	public int insert(Employee employee);

	@Update("Update employees set name=#{name},city=#{city},salary=#{salary} where id=#{id}")
	public int update(Employee employee);
}