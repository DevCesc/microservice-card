package com.bootcamp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.entity.Card;

@Repository
public interface CardRepository extends ReactiveMongoRepository<Card,ObjectId> {

}
