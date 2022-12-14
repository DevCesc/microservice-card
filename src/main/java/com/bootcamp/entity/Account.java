package com.bootcamp.entity;



import org.bson.types.ObjectId;

import lombok.Data;

@Data
public class Account {

	private ObjectId idClient;
	private String numberAccount;
	
}
