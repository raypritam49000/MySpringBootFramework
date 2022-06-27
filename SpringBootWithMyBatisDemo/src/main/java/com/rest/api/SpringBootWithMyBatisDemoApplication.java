package com.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.api.repository.EmployeeMyBatisRepository;

@SpringBootApplication
public class SpringBootWithMyBatisDemoApplication implements CommandLineRunner {
	
	@Autowired
	private EmployeeMyBatisRepository batisRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMyBatisDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(batisRepository.findAll());
		
	}

}
