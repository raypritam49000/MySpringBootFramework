package com.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;

import com.rest.api.entity.NextSequenceService;
import com.rest.api.entity.Student;

@SpringBootApplication
public class SpringBootWithMongoOperationDemoApplication implements CommandLineRunner {

	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	private NextSequenceService nextSequenceService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMongoOperationDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(mongoOperations);

		Student student = new Student();
		student.setCity("Ropar");
		student.setId(nextSequenceService.getNextSequence("customSequences"));
		student.setName("Pritam Ray");
		student.setSalary(45000d);
		mongoOperations.save(student);

		List<Student> students = this.mongoOperations.findAll(Student.class);
		System.out.println(students);

		Student student1 = this.mongoOperations.findById(2, Student.class);
		System.out.println(student1);
		

	}

}
