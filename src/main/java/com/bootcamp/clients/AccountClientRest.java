package com.bootcamp.clients;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.bootcamp.entity.Account;

import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "microservice-account")
public interface AccountClientRest {
	
	
    //@PostMapping(value = "/saveTransaction")
    //public Mono<Account> saveTransaction(@RequestBody Transaction transaction);

}
