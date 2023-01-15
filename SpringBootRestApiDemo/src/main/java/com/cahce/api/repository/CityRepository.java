package com.cahce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cahce.api.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
