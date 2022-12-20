package com.bootcamp.service;


import com.bootcamp.entity.Association;
import com.bootcamp.entity.Card;
import com.bootcamp.entity.ResponsePayment;

import reactor.core.publisher.Mono;

public interface CardService {
	
	public Mono<Card> saveCard(Card card); 
	
	public Mono<ResponsePayment> savePayByCardDebit(Card card);
	
	public Mono<Card> findCardByNumber(Association association);

}
