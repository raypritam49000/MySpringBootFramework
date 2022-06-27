package com.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.entity.Student;
import com.rest.api.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServices{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudent() {
		return this.studentRepository.findAll();
	}

	@Override
	public Student getStudent(int id) {
		return this.studentRepository.findById(id).get();
	}

	@Override
	public Boolean deleteStudent(int id) {
		Student student = this.studentRepository.findById(id).get();
		
		if(student!=null) {
			this.studentRepository.delete(student);
			return true;
		}
		return false;
	}

	@Override
	public Boolean createStudent(Student student) {
		this.studentRepository.save(student);
		return true;
	}

	@Override
	public Boolean updateStudent(int id, Student student) {
		Student existingStudent = this.studentRepository.findById(id).get();
		
		if(existingStudent!=null) {
			existingStudent.setName(student.getName());
			existingStudent.setCity(student.getCity());
			existingStudent.setSalary(student.getSalary());
			this.studentRepository.save(existingStudent);
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	

}
