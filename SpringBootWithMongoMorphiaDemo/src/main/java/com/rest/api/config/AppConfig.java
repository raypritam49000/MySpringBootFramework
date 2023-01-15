package com.rest.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.rest.api.entity.Student;

import dev.morphia.Datastore;
import dev.morphia.Morphia;

@Configuration
public class AppConfig {

	@Bean
	public MongoClient mongoClient() {
		return new com.mongodb.MongoClient("localhost", 27017);
	}

	@Bean
	public Datastore datastore() {
		Morphia morphia = new Morphia();
		morphia.map(Student.class);
		Datastore datastore = morphia.createDatastore(mongoClient(), "test");
		datastore.ensureIndexes();
		return datastore;
	}

}
