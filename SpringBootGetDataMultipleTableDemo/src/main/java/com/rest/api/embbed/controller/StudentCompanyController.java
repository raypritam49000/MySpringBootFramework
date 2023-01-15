package com.rest.api.embbed.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.embbed.entity.Student;
import com.rest.api.embbed.entity.StudentCompany;
import com.rest.api.embbed.services.StudentService;

@RestController
@RequestMapping("/rest/api")
public class StudentCompanyController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/allStudentsById/{companyId}")
	public List<Student> findByStudentIdentityCompanyId(@PathVariable("companyId") int companyId){
		return this.studentService.findByStudentIdentityCompanyId(companyId);
	}
	
	@GetMapping("/allStudents")
	public List<StudentCompany> getStudentallStudents(){
		return this.studentService.getStudentallStudents();
	}
	
	@PostMapping("/createStudent")
	public Map<String,Student> createStudent(@RequestBody Student student){
		return this.studentService.createStudent(student);
	}
	
	@DeleteMapping("/deleteStudent/{studentId}")
	public Map<String,Boolean> deleteStudent(@PathVariable("studentId") int studentId){
		return this.studentService.deleteStudent(studentId);
	}
}
