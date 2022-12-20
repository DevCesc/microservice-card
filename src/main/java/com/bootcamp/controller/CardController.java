package com.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.bootcamp.entity.Card;
import com.bootcamp.service.CardService;

import reactor.core.publisher.Mono;

@RestController
public class CardController {

	@Autowired 
	private CardService cardService;
	
	@PostMapping(value = "/saveCard")
	public Mono<ResponseEntity<Card>> saveCard(@RequestBody Card card) {
		return cardService.saveCard(card).map(e -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(e))
        .defaultIfEmpty(ResponseEntity.notFound().build());
	
    }
	
	@PostMapping(value ="/payByCardDebit")
	public Mono<ResponseEntity<Card>> paybyCardDebit(){
		return null;
	}
	

	
}
