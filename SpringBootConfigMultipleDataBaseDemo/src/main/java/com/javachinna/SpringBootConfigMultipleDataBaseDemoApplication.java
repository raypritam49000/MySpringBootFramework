package com.javachinna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javachinna.repo.product.ProductInfoRepository;

@SpringBootApplication
public class SpringBootConfigMultipleDataBaseDemoApplication implements CommandLineRunner{

	@Autowired
	private ProductInfoRepository p;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigMultipleDataBaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(p.getProductInfo());
	}

}
