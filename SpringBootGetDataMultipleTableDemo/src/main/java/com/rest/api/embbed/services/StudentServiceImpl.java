package com.rest.api.embbed.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.api.embbed.entity.Student;
import com.rest.api.embbed.entity.StudentCompany;
import com.rest.api.embbed.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findByStudentIdentityCompanyId(int companyId) {
		return this.studentRepository.findByStudentIdentityCompanyId(companyId);
	}

	@Override
	public List<StudentCompany> getStudentallStudents() {

		StudentCompany studentCompany = null;
		List<StudentCompany> reponseList = new ArrayList<StudentCompany>();

		List<Object[]> students = this.studentRepository.getStudentallStudents();

		for (Object[] student : students) {
			int studentId = (int) student[0];
			int companyId = (int) student[1];
			String name = (String) student[2];
			String email = (String) student[3];
			String mobile = (String) student[4];

			System.out.println(studentId + " " + companyId + " " + name + " " + email + " " + mobile);

			studentCompany = new StudentCompany(studentId, companyId, name, email, mobile);

			reponseList.add(studentCompany);

		}
		return reponseList;
	}

	@Override
	public Map<String, Student> createStudent(Student student) {
		return Map.of("Student Created Success", this.studentRepository.save(student));
	}

	@Override
	public Map<String, Boolean> deleteStudent(int studentId) {
		Student student = this.studentRepository.findByStudentIdentityStudentId(studentId);

		if (student != null) {
			this.studentRepository.delete(student);
		}
		return Map.of("Student Deleted Success", Boolean.TRUE);
	}

}
