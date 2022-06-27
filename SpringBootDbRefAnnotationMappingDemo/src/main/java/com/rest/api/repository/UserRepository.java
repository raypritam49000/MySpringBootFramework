package com.rest.api.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

}
