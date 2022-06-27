package com.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//enabling caching  
@EnableCaching  
@EnableSwagger2
@SpringBootApplication
public class SpringBootWithCacheRestApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithCacheRestApiDemoApplication.class, args);
	}

}
