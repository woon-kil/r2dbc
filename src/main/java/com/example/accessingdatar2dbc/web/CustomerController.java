package com.example.accessingdatar2dbc.web;

import com.example.accessingdatar2dbc.Customer;
import com.example.accessingdatar2dbc.CustomerRepository;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.time.Duration;

@Slf4j
@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/flux")
    public Flux<Integer> flux(){
        return Flux.just(1,2,3,4,5).delayElements(Duration.ofSeconds(1)).log();
    }

    @GetMapping(value = "/fluxstream",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> fluxstream(){
        return Flux.just(1,2,3,4,5).delayElements(Duration.ofSeconds(3)).log();
    }

    @GetMapping("/customer")
    public Flux<Customer> findAll(){
    return customerRepository.findAll().log();
    };
}