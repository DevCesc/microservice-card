package com.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.entity.Card;
import com.bootcamp.repository.CardRepository;

import reactor.core.publisher.Mono;

@Service
public class CardServiceImpl implements CardService {

	
	@Autowired
	CardRepository cardRepository;
	
	@Override
	public Mono<Card> saveCard(Card card) {
		return cardRepository.save(card);
	}

}
