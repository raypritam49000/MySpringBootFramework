package com.rest.api.services;

import java.util.List;

import com.rest.api.entity.Student;

public interface StudentServices {
	public abstract List<Student> getAllStudent();

	public abstract Student getStudent(int id);

	public abstract Boolean deleteStudent(int id);

	public abstract Boolean createStudent(Student student);

	public abstract Boolean updateStudent(int id, Student student);

}
