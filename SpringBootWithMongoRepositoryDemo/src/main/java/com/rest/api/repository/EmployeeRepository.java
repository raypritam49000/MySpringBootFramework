package com.rest.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

}
