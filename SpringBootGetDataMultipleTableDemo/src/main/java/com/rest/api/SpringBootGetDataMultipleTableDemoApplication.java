package com.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.rest.api.entity", "com.rest.api.user.entity","com.rest.api.embbed.entity","com.rest.api.teacher.entity" })
@EnableJpaRepositories(basePackages = { "com.rest.api.repositories", "com.rest.api.user.repositories","com.rest.api.embbed.repositories", "com.rest.api.teacher.repository" })
public class SpringBootGetDataMultipleTableDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGetDataMultipleTableDemoApplication.class, args);
	}

}
