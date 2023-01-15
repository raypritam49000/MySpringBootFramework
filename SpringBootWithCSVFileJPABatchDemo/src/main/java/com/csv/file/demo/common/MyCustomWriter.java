package com.csv.file.demo.common;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csv.file.demo.entity.Employee;
import com.csv.file.demo.repository.EmployeeRepository;

@Component
public class MyCustomWriter implements ItemWriter<Employee> {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void write(List<? extends Employee> list) throws Exception {
		for (Employee data : list) {
			System.out.println("MyCustomWriter    : Writing data    : " + data.getId() + " : " + data.getName() + " : "
					+ data.getSalary());
			employeeRepository.save(data);
		}
	}
}