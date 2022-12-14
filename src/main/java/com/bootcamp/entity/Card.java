package com.bootcamp.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "card")
public class Card {

	private ObjectId id;
	private String  cardNumber;
	private Integer expirationMonth;
	private Integer expirationYear;
	private Integer cvv2;
	private Account account;
	
}
