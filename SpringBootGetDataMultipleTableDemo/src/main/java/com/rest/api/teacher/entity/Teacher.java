package com.rest.api.teacher.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(CompositeTaskId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

	@Id
	private int teacherId;
	@Id
	private int taskId;

	private String name;
	private String city;
	private String email;

}