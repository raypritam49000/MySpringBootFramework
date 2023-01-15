package com.rest.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.api.entity.User;

@Repository
public interface FlipKartRepository extends MongoRepository<User, Integer> {
	public abstract List<User> findByName(String name);

	@Query("{'Address.city':?0}")
	public abstract List<User> findByCity(String city);
}
