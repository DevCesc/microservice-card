package com.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.entity.Association;
import com.bootcamp.entity.Card;
import com.bootcamp.entity.DataClient;
import com.bootcamp.entity.ResponsePayment;
import com.bootcamp.repository.CardRepository;

import reactor.core.publisher.Mono;

@Service
public class CardServiceImpl implements CardService {

	
	private final DataClientEventService dataClientEventService;

	@Autowired
	public CardServiceImpl(DataClientEventService dataClientEventService) {
		super();
		this.dataClientEventService = dataClientEventService;
	}
	
	@Autowired
	private CardRepository cardRepository;
	
	@Override
	public Mono<Card> saveCard(Card card) {
		return cardRepository.save(card);
	}

	@Override
	public Mono<ResponsePayment> savePayByCardDebit(Card card) {
		
		/*cardRepository.findAll().
					 filter(x-> x.getCardNumber().equals(card.getCardNumber()))
					 .flatMap(a -> a.getAccount().getNumberAccount());*/
		
		return null;
	}

	@Override
	public Mono<Card> findCardByNumber(Association association) {
		Mono<Card> monoCard =cardRepository.findAll().filter(x-> x.getCardNumber().equals(association.getCardNumber())).next();
		DataClient objDataClient = new DataClient();
		Card obj = monoCard.block();
		System.out.println("el id en microservice card: "+obj.getIdClient().toString());
		objDataClient.setIdClient(obj.getIdClient().toString());
		objDataClient.setIdYanki(association.getIdYanki());
		System.out.println("el id en microservice card: 22222 "+objDataClient.getIdYanki().toString());
		this.dataClientEventService.publish(objDataClient);
		return monoCard;
	}

}
