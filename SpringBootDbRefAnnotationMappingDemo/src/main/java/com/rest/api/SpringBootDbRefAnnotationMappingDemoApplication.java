package com.rest.api;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.api.entity.Address;
import com.rest.api.entity.Product;
import com.rest.api.entity.User;
import com.rest.api.repository.AddressRepository;
import com.rest.api.repository.ProductRepository;
import com.rest.api.repository.UserRepository;

@SpringBootApplication
public class SpringBootDbRefAnnotationMappingDemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDbRefAnnotationMappingDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//
//		this.productRepository.save(new Product("Mobile",1,14000));
//		this.productRepository.save(new Product("Cooler",1,54000));
//
//		this.addressRepository.save(new Address("Ropar", "Punjab", "144533"));
//

		List<Product> productList = List.of(new Product(new ObjectId("6249519d28abac0f0c484f73"),"Mobile", 1, 14000), new Product(new ObjectId("6249519d28abac0f0c484f74"),"Cooler", 1, 54000));
		Address address = new Address(new ObjectId("6249519d28abac0f0c484f75"),"Ropar", "Punjab", "144533");
		
		User user = new User();
		user.setName("Pritam Ray");
		user.setGender("Male");
		user.setAddress(address);
		user.setProducts(productList);
		
		this.userRepository.save(user);

	}

}
