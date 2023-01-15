package com.rest.api.embbed.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.api.embbed.entity.Student;
import com.rest.api.embbed.entity.StudentIdentity;

@Repository
public interface StudentRepository extends JpaRepository<Student, StudentIdentity> {

	public List<Student> findByStudentIdentityCompanyId(int companyId);
	
	public Student findByStudentIdentityStudentId(int studentId);

	@Query(value = "SELECT studentIdentity.studentId,studentIdentity.companyId,name,email,phoneNumber FROM Student")
	public abstract List<Object[]> getStudentallStudents();

}