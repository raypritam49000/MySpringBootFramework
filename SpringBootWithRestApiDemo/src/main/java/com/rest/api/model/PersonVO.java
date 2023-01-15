package com.rest.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonVO {
	private Integer id;
	private String name;
	private String city;
	private String salary;
}