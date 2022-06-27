package com.rest.api;

import java.util.Iterator;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@SpringBootApplication
public class SpringBootWithMongoClientDemoApplication implements CommandLineRunner {

	@Autowired
	private MongoClient mongoClient;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMongoClientDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(mongoClient);
		mongoClient.listDatabaseNames().forEach(System.out::println);

		// ---------- Creating DataBase ---------------------------//
		MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

		// ---------- Creating Collection -------------------------//
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("employee");

		// ---------- Creating Document ---------------------------//
		Document document = new Document();
		document.append("id", 15);
		document.append("salary", "45000");
		document.append("name", "Pritam Ray");
		document.append("city", "Ropar");

		// ----------- Inserting Data ------------------------------//
		System.out.println("===>>> Save Data in Mongo Database");
		mongoCollection.insertOne(document);

		System.out.println("===>>> Delete Data in Mongo Database");
		mongoCollection.deleteMany(Filters.eq("id", 13));

		// Retrieving the documents
		System.out.println("====>>> Get All Data From Mongo Database");
		FindIterable<Document> iterDoc = mongoCollection.find();
		Iterator<Document> it = iterDoc.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("====>>> Get Single Data From Mongo Database");
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("id", 11);

		FindIterable<Document> findIterable = mongoCollection.find(whereQuery);
		Iterator<Document> iterator = findIterable.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
//		}

			// print the third document before update.
			Document third = mongoCollection.find(Filters.eq("id", 11)).first();
			System.out.println(third.toJson());

			Document findQuery = new Document();
			findQuery.append("id", 11);

			Document updateQuery = new Document();
			updateQuery.append("name", "Amit Kumar");
			updateQuery.append("city", "Rail");
			updateQuery.append("salary", "45000");

			mongoCollection.updateOne(findQuery, new Document("$set", updateQuery));

			System.out.println("===>>> Updated third document:");
			Document dilbert = mongoCollection.find(Filters.eq("id", 11)).first();
			System.out.println(dilbert.toJson());

		}

	}
}
