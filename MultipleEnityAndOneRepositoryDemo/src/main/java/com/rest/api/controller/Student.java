package com.rest.api.controller;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student extends BaseId {
	private String name;
	private String city;
	private String salary;
}
