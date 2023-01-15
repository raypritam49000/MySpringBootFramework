package com.cahce.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cahce.api.entity.City;
import com.cahce.api.services.CityService;

@RestController
public class CityController {

	@Autowired  
    private CityService cityService;

	@PostMapping("/cities")
	public ResponseEntity<City> saveCity(@RequestBody City city) {
		return new ResponseEntity<>(cityService.saveCity(city), HttpStatus.CREATED);
	}

	@GetMapping("/cities/{id}")
	public ResponseEntity<City> getCityById(@PathVariable(name = "id") Integer id) {
		System.out.println(">>> Get City By Id");
		return new ResponseEntity<>(cityService.getCityById(id), HttpStatus.OK);
	}
}