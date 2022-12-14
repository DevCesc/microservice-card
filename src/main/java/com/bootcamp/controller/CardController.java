package com.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bootcamp.entity.Card;
import com.bootcamp.service.CardService;

import reactor.core.publisher.Mono;

@Controller
public class CardController {

	@Autowired 
	CardService cardService;
	
	@PostMapping(value = "/saveCard")
	public Mono<Card> saveCard(@RequestBody Card card) {
		return cardService.saveCard(card);
	}
}
