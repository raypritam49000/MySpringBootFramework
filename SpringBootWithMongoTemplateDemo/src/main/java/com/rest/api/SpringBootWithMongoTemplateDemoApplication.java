package com.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.rest.api.entity.Book;

@SpringBootApplication
public class SpringBootWithMongoTemplateDemoApplication implements CommandLineRunner {

	@Autowired
	private MongoTemplate mt;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMongoTemplateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		mt.save(new Book(500, "Core Java", 200, "Kathy Sierra", 1065.5));
		mt.save(new Book(501, "JSP & Servlets", 350, "Kathy Sierra", 1749.0));
		// mt.save(new Book(501, "JSP & Servlets", 350, "Kathy Sierra", 1749.0),"Book");
		// // save () with collection name 'Book'
		mt.save(new Book(502, "Spring in Action", 480, "Craig Walls", 940.75));
		mt.save(new Book(503, "Pro Angular", 260, "Freeman", 1949.25));
		mt.save(new Book(504, "HTML CSS", 100, "Thomas Powell", 2317.09));
		mt.save(new Book(505, "Hibernate in Action", 180, "Gavin King", 889.25));
		mt.save(new Book(506, "Practical MongoDB", 180, "Shakuntala Gupta", 785.0));
		mt.save(new Book(507, "Pro Spring Boot", 850, "Felipe Gutierrez", 2167.99));
		mt.save(new Book(508, "Beginning jQuery", 180, "Franklin", 1500.00));
		mt.save(new Book(509, "Java Design Patterns", 114, "Devendra Singh", 919.99));

		System.out.println("------All records has been saved successfully-------");

		mt.insert(List.of(new Book(400, "Core Java", 200, "Kathy Sierra", 1065.5),
				new Book(401, "JSP & Servlets", 350, "Kathy Sierra", 1749.0),
				new Book(402, "Spring in Action", 480, "Craig Walls", 940.75),
				new Book(403, "Pro Angular", 260, "Freeman", 1949.25),
				new Book(404, "HTML CSS", 100, "Thomas Powell", 2317.09),
				new Book(405, "Hibernate in Action", 180, "Gavin King", 889.25),
				new Book(406, "Practical MongoDB", 180, "Shakuntala Gupta", 785.0),
				new Book(407, "Pro Spring Boot", 850, "Felipe Gutierrez", 2167.99),
				new Book(408, "Beginning jQuery", 180, "Franklin", 1500.00),
				new Book(409, "Java Design Patterns", 114, "Devendra Singh", 919.99)), "Book");

		System.out.println("------All records has been saved successfully-------");

		mt.insertAll(List.of(new Book(600, "Core Java", 200, "Kathy Sierra", 1065.5),
				new Book(601, "JSP & Servlets", 350, "Kathy Sierra", 1749.0),
				new Book(602, "Spring in Action", 480, "Craig Walls", 940.75),
				new Book(603, "Pro Angular", 260, "Freeman", 1949.25),
				new Book(604, "HTML CSS", 100, "Thomas Powell", 2317.09),
				new Book(605, "Hibernate in Action", 180, "Gavin King", 889.25),
				new Book(606, "Practical MongoDB", 180, "Shakuntala Gupta", 785.0),
				new Book(607, "Pro Spring Boot", 850, "Felipe Gutierrez", 2167.99),
				new Book(608, "Beginning jQuery", 180, "Franklin", 1500.00),
				new Book(609, "Java Design Patterns", 114, "Devendra Singh", 919.99)));

		System.out.println("------All records has been saved successfully-------");

		List<Book> list = mt.findAll(Book.class);
		// List<Book> list = mt.findAll(Book.class,"Book"); //If collection name & the
		// Entity Class Name are different (case-sensitive)
		list.forEach(System.out::println);
		
		Book book = mt.findById(504, Book.class);
		//Book book = mt.findById(501, Book.class,"Book");
		System.out.println(book);
		
		Query query= new Query();
		query.addCriteria(Criteria.where("id").is(501));

		Update update = new Update();
		update.set("cost", 1065.25);
		update.set("name", "Core Java");

		mt.findAndModify(query, update, Book.class);
		System.out.println("Data Modified");
		
		
		Query query1= new Query(); 
		query1.addCriteria(Criteria.where("pages").lte(180));
		Update update1 = new Update();
		update1.set("cost", 999.0);
		mt.updateMulti(query1, update1, Book.class);
		
//		Query query4= new Query(); 
//		query.addCriteria(Criteria.where("id").is(501));
//		Update update4 = new Update();
//		update4.set("cost", 1065.25);
//		update4.set("name", "Core Java");
//		 mt.upsert(query4, update4, Book.class);
		
//		Query query2= new Query();
//		query2.addCriteria(Criteria.where("cost").is(1749.0));
//		mt.findAndRemove(query2, Book.class);
//		
//		Query query3= new Query();
//		query3.addCriteria(Criteria.where("cost").gte(1000.0));
//		mt.findAllAndRemove(query3, Book.class);
		
	}

}
