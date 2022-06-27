package com.rest.api.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rest.api.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	class EmployeeRowMapper implements RowMapper<Employee> {
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setId(rs.getLong("id"));
			employee.setName(rs.getString("name"));
			employee.setCity(rs.getString("city"));
			employee.setSalary(rs.getString("salary"));
			return employee;
		}
	}

	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("select * from employees", new EmployeeRowMapper());
	}

	@Override
	public int deleteById(long id) {
		return jdbcTemplate.update("delete from employees where id=?", new Object[] { id });
	}

	@Override
	public int insert(Employee employee) {
		return jdbcTemplate.update("insert into employees (id,name,city,salary) " + "values(?, ?, ?, ?)",
				new Object[] { employee.getId(), employee.getName(), employee.getCity(), employee.getSalary() });
	}

	@Override
	public int update(Employee employee) {
		return jdbcTemplate.update("update employees " + " set name = ?,city = ?, salary = ? " + " where id = ?",
				new Object[] { employee.getName(), employee.getCity(), employee.getSalary(), employee.getId() });
	}

	@Override
	public Employee findById(long id) {
		String query = "select * from employees where id=?";
		Optional<Employee> optional = Optional.of(jdbcTemplate.queryForObject(query, new Object[] { id },
				new BeanPropertyRowMapper<Employee>(Employee.class)));
		Employee employee = optional.get();
		return employee;

	}
}
