package com.bootcamp.service;

import com.bootcamp.entity.Card;

import reactor.core.publisher.Mono;

public interface CardService {
	
	public Mono<Card> saveCard(Card card); 

}
