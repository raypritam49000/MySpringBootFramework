package com.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.entity.User;
import com.rest.api.repository.FlipKartRepository;

@RestController
@RequestMapping("/order-service")
public class FlipKartOMController {

	@Autowired
	private FlipKartRepository flipKartRepository;

	@PostMapping("/palcedOrderNow")
	public String placeOrder(@RequestBody User user) {
		this.flipKartRepository.save(user);
		return "Orders are placed successfully";
	}
	

	@GetMapping("/getUserByName/{name}")
	public List<User> getUserByName(@PathVariable("name") String name) {
		return this.flipKartRepository.findByName(name);
	}
	

	@GetMapping("/getUserByAddress/{city}")
	public List<User> getUserByAddress(@PathVariable("city") String city) {
		return this.flipKartRepository.findByCity(city);
	}



}
