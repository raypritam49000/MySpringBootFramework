package com.rest.api.embbed.services;

import java.util.List;
import java.util.Map;

import com.rest.api.embbed.entity.Student;
import com.rest.api.embbed.entity.StudentCompany;

public interface StudentService {
	public List<Student> findByStudentIdentityCompanyId(int companyId);
	public abstract List<StudentCompany> getStudentallStudents();
	public Map<String,Student> createStudent(Student student);
	public Map<String, Boolean> deleteStudent(int studentId);
}
