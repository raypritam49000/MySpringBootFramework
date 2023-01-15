package com.rest.api.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.entity.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address, ObjectId>{

}
