package com.rest.api.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Employee {
	private int id;
	private String name;
	private String city;
	private String salary;
}
