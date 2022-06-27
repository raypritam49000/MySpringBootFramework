package com.rest.api.teacher.services;

import java.util.List;

import com.rest.api.teacher.entity.Teacher;

public interface TeacherService {
	public abstract List<?> getAllTeachers();
	public abstract List<Teacher> getAllTechersData();
}
