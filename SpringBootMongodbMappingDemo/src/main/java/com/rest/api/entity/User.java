package com.rest.api.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order_db")
public class User {
	@Id
	private int id;
	private String name;
	private String gender;
	private List<Product> products;
	private Address address;
}
