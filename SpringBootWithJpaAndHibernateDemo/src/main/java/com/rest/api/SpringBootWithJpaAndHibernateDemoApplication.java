package com.rest.api;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.api.entity.Student;

@Transactional
@SpringBootApplication
public class SpringBootWithJpaAndHibernateDemoApplication implements CommandLineRunner {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private Session session;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithJpaAndHibernateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(entityManager);
		System.out.println(entityManager.unwrap(Session.class));
		System.out.println(sessionFactory);
		System.out.println(session);

		Student student = new Student();
		student.setCity("Ropar");
		student.setName("Pritam Ray");
		student.setSalary("45000");

		session.save(student);

	}

}
