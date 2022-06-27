package com.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.api.entity.Person;
import com.rest.api.repository.PersonRepository;

@SpringBootApplication
public class SpringBootH2DataBaseDemoApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2DataBaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World....");

		Person p1 = new Person("Pritam Ray", "Mohali", 20000.00);
		Person p2 = new Person("Ram Kumar", "Ropar", 27000.00);
		Person p3 = new Person("Amit Kumar", "Asron", 70000.00);
		Person p4 = new Person("Ajit Kumar", "Rail", 50000.00);

		this.personRepository.save(p1);

		this.personRepository.saveAll(List.of(p1, p2, p3, p4));

////          this.personRepository.delete(p4);
////          
////          this.personRepository.deleteAll();
//
////		List<Person> persons = this.personRepository.findAll();
////		System.out.println(persons);
////
////		Person person = this.personRepository.findById(2L).get();
////		System.out.println(person);
		
		Person person = this.personRepository.findById(2L).get();
		
		if(person!=null) {
			person.setName("Suraj Mehta");
			person.setCity("Prem Nagar");
			person.setSalary(60000.00);
			
			this.personRepository.save(person);
		}
		else {
			System.out.println("User Not Found !!!!");
		}

	}

}
