package com.rest.api.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.teacher.entity.Teacher;
import com.rest.api.teacher.services.TeacherService;

@RestController
@RequestMapping("/rest/api")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/allTeachers")
	public List<Teacher> getAllTeachers(){
		return (List<Teacher>) this.teacherService.getAllTeachers();
	}
	
	@GetMapping("/allTeachersData")
	public List<Teacher> getAllTechersData(){
		return this.teacherService.getAllTechersData();
	}
}
