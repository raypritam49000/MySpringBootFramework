package com.rest.api;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.rest.api.enity.Person;

@Transactional
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@SpringBootApplication
public class SpringBootHibernateTemplateDemoApplication implements CommandLineRunner {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateTemplateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(hibernateTemplate);

		Person person = new Person();
		person.setCity("Ropar");
		person.setName("Pritam Ray");
		person.setSalary("45000");

		hibernateTemplate.save(person);

		List<Person> persons = hibernateTemplate.loadAll(Person.class);
		System.out.println(persons);

		Person findPersonById = hibernateTemplate.load(Person.class, 2);
		System.out.println(findPersonById);

		// hibernateTemplate.delete(findPersonById);

		findPersonById.setCity("Rail");
		findPersonById.setName("Ray");
		findPersonById.setSalary("23000");

		// hibernateTemplate.save(findPersonById);

		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
        System.out.println(sessionFactory);
        
        Session session = sessionFactory.openSession();
        Person persondb = session.byId(Person.class).getReference(3);
        System.out.println(persondb);
	}

}
