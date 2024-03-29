package com.rest.api.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.rest.api.controller.EmployeeController;

@Configuration
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(EmployeeController.class);
	}
}