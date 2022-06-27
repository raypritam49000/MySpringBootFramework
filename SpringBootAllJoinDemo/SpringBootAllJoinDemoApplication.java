package com.database.join.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@EntityScan("com.database.join.api.entity") 
@EnableJpaRepositories("com.database.join.api.repository")
public class SpringBootAllJoinDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAllJoinDemoApplication.class, args);
	}

}
