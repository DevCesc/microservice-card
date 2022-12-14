package com.bootcamp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.entity.Card;

@Repository
public interface CardRepository extends ReactiveCrudRepository<Card,ObjectId> {

}
