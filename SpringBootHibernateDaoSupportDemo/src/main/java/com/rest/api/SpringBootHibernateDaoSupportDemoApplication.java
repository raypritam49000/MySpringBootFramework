package com.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.api.dao.PersonDao;
import com.rest.api.entity.Person;

@SpringBootApplication
public class SpringBootHibernateDaoSupportDemoApplication implements CommandLineRunner{
	
	@Autowired
	private PersonDao personDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateDaoSupportDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.personDao.savePerson(new Person("Omi Verma","Ropar","45000"));
		System.out.println(this.personDao.getPersonDetails());
		System.out.println(personDao.getPersonById(1));
	}

}
