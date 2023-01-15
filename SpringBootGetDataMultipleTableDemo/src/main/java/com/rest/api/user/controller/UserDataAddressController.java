package com.rest.api.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.user.entity.UserAddress;
import com.rest.api.user.entity.UserData;
import com.rest.api.user.services.UserServices;

@RestController
public class UserDataAddressController {
	
	@Autowired
	private UserServices userService;
	
	@PostMapping("/createUser")
	public Map<String, UserData> createUserData(@RequestBody UserData userData){
	  return this.userService.createUserData(userData);
	}
	
	@PostMapping("/createUserAddress")
	public Map<String, UserAddress> createUserAddress(@RequestBody UserAddress userAddress) {
		return this.userService.createUserAddress(userAddress);
	}
	
	
	@GetMapping("/userdata/{userId}")
	public List<UserData> findBySearchTerm(@PathVariable("userId") Long userId){
		return this.userService.findBySearchTerm(userId);
	}
 
	@GetMapping("/getcity/{userId}")
	public String findCityByUserId(@PathVariable("userId") Long userId) {
	  return this.userService.findCityByUserId(userId);	
	}
	
}
