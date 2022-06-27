package com.rest.api.entity;

import org.bson.types.ObjectId;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(value = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	private ObjectId _id;
	private String name;
	private String city;
	private String salary;
}
