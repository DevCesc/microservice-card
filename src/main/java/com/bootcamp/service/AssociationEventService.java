package com.bootcamp.service;

import org.springframework.stereotype.Component;


import com.bootcamp.entity.Card;
import com.bootcamp.event.AssociationCreatedEvent;
import com.bootcamp.event.Event;


import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;


@Slf4j
@Component
public class AssociationEventService {
	

	
	@Autowired
	private CardService cardService;

	@KafkaListener(
			topics = "topic-yanki-1" ,
			containerFactory = "kafkaListenerContainerFactory",
	groupId = "grupo1")
	public void consumer(Event<?> event) {
		if (event.getClass().isAssignableFrom(AssociationCreatedEvent.class)) {
			AssociationCreatedEvent customerCreatedEvent = (AssociationCreatedEvent) event;
			log.info("Received desde card service created event .... with Id={}, data={}",
					customerCreatedEvent.getId(),
					customerCreatedEvent.getData().getIdYanki());
		 	Mono<Card> mono = cardService.findCardByNumber(customerCreatedEvent.getData());
		 	mono.doOnNext(x->System.out.println(x.getCardNumber()));
		}
		
		

	}
	


	
}
