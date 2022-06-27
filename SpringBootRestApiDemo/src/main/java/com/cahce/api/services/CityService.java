package com.cahce.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cahce.api.entity.City;
import com.cahce.api.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	public City getCityById(Integer id) {
		return cityRepository.findById(id).get();
	}

	public City saveCity(City city) {
		return cityRepository.save(city);
	}

}
