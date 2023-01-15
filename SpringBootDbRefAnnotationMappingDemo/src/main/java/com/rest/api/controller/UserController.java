package com.rest.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.entity.Address;
import com.rest.api.entity.Product;
import com.rest.api.entity.User;
import com.rest.api.repository.AddressRepository;
import com.rest.api.repository.ProductRepository;
import com.rest.api.repository.UserRepository;

@RestController
@RequestMapping("/rest/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsers() {
		try
		{
			List<User> userList = this.userRepository.findAll();
			
			if(userList!=null && userList.size()>0) {
				return ResponseEntity.ok(Map.of("body",userList,"message","List User","status",200,"success",true));
			}
			else {
				return ResponseEntity.ok(Map.of("message","DATA_NOT_FOUND","status",404,"body",userList,"success",false));
			}
			
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message","INTERNAL_SERVER_ERROR","status",502,"body",e.getMessage(),"success",false));
		}
	}
	
	@GetMapping("/getAllAddress")
	public ResponseEntity<?> getAllAddress() {
		try
		{
			List<Address> addressList = this.addressRepository.findAll();
			
			if(addressList!=null && addressList.size()>0) {
				return ResponseEntity.ok(Map.of("body",addressList,"message","Address List","status",200,"success",true));
			}
			else {
				return ResponseEntity.ok(Map.of("message","DATA_NOT_FOUND","status",404,"body",addressList,"success",false));
			}
			
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message","INTERNAL_SERVER_ERROR","status",502,"body",e.getMessage(),"success",false));
		}
	}
	
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<?> getAllProducts() {
		try
		{
			List<Product> productList = this.productRepository.findAll();
			
			if(productList!=null && productList.size()>0) {
				return ResponseEntity.ok(Map.of("body",productList,"message","Product List","status",200,"success",true));
			}
			else {
				return ResponseEntity.ok(Map.of("message","DATA_NOT_FOUND","status",404,"body",productList,"success",false));
			}
			
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("message","INTERNAL_SERVER_ERROR","status",502,"body",e.getMessage(),"success",false));
		}
	}
	
	
}
