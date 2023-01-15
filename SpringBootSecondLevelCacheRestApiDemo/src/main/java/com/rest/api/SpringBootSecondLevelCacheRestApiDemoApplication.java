package com.rest.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.api.entity.Course;
import com.rest.api.entity.FullTimeEmployee;
import com.rest.api.entity.PartTimeEmployee;
import com.rest.api.entity.Review;
import com.rest.api.entity.Student;
import com.rest.api.repository.CourseRepository;
import com.rest.api.repository.EmployeeRepository;
import com.rest.api.repository.StudentRepository;

@SpringBootApplication
public class SpringBootSecondLevelCacheRestApiDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecondLevelCacheRestApiDemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		 studentRepository.saveStudentWithPassport();
		 courseRepository.playWithEntityManager();
		 courseRepository.addHardcodedReviewsForCourse();
		 List<Review> reviews = new ArrayList<>();

		 reviews.add(new Review("5", "Great Hands-on Stuff."));
		 reviews.add(new Review("5", "Hatsoff."));

		 courseRepository.addReviewsForCourse(10003L, reviews );
		 studentRepository.insertHardcodedStudentAndCourse();
		 studentRepository.insertStudentAndCourse(new Student("Jack"),
		 new Course("Microservices in 100 Steps"));

		// Jack FullTimeEmployee salary - 10000$
		// Jill PartTimeEmployee - 50$ per hour
		
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

		logger.info("Full Time Employees -> {}", 
				employeeRepository.retrieveAllFullTimeEmployees());
		
		logger.info("Part Time Employees -> {}", 
				employeeRepository.retrieveAllPartTimeEmployees());
	}

}
