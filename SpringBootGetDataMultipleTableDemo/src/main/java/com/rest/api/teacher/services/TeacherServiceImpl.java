package com.rest.api.teacher.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.teacher.entity.Teacher;
import com.rest.api.teacher.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public List<Teacher> getAllTeachers() {
		return this.teacherRepository.getAllTeachers();
	}

	@Override
	public List<Teacher> getAllTechersData() {
		List<Teacher> responseList = new ArrayList<Teacher>();
		Teacher teacher = null;
		List<Object[]> objects = this.teacherRepository.getAllTechersData();

		for (Object[] object : objects) {
			int teacherId = (int) object[0];
			int taskId = (int) object[1];
			String name = (String) object[2];
			String city = (String) object[3];
			String email = (String) object[4];
			teacher = new Teacher(teacherId, taskId, name, city, email);
			responseList.add(teacher);
		}
		return responseList;
	}
}
