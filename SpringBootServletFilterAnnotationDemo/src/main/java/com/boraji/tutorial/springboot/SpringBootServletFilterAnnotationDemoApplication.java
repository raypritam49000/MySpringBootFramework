package com.boraji.tutorial.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = { "com.boraji.tutorial.springboot.servlet",
		"com.boraji.tutorial.springboot.filter", "com.boraji.tutorial.springboot.listener" })
public class SpringBootServletFilterAnnotationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServletFilterAnnotationDemoApplication.class, args);
	}

}
