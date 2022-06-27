package com.rest.api;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.api.entity.Student;

import dev.morphia.Datastore;
import dev.morphia.query.Query;

@SpringBootApplication
public class SpringBootWithMongoMorphiaDemoApplication implements CommandLineRunner {

	@Autowired
	private Datastore datastore;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMongoMorphiaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(datastore);

		Student st = new Student();
		st.setCity("Ropar");
		st.setName("Pritam Ray");
		st.setSalary("45000");
		datastore.save(st);

		List<Student> students = this.datastore.createQuery(Student.class).asList();
		System.out.println(students);

		Query<Student> query = datastore.find(Student.class).field("_id")
				.equal(new ObjectId("62419c3de949d11c7bcb5559"));
		Student student = query.get();
		System.out.println(student);

		Query<Student> deleteQuery = datastore.find(Student.class).field("_id")
				.equal(new ObjectId("62419c3de949d11c7bcb5559"));
		System.out.println(datastore.findAndDelete(deleteQuery));

	}

}
