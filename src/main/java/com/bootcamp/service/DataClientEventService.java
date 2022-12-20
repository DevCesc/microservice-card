package com.bootcamp.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.bootcamp.entity.Card;
import com.bootcamp.entity.DataClient;
import com.bootcamp.event.DataClientCreatedEvent;
import com.bootcamp.event.Event;
import com.bootcamp.event.EventType;

import lombok.extern.slf4j.Slf4j;

@Component
public class DataClientEventService {
	
	@Autowired
	private KafkaTemplate<String,Event<?>> producer;

	public void publish(DataClient dataClient) {
		DataClientCreatedEvent created = new DataClientCreatedEvent();
		created.setData(dataClient);
		created.setId(UUID.randomUUID().toString());
		created.setType(EventType.CREATED);
		created.setDate(new Date());
		this.producer.send("topic-yanki-2",created);
	}
}
