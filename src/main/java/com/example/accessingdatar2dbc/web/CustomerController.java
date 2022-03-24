package com.example.accessingdatar2dbc.web;

import com.example.accessingdatar2dbc.Customer;
import com.example.accessingdatar2dbc.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/flux")
    public Flux<Integer> flux(){
        return Flux.just(1,2,3,4,5);
    }

    @GetMapping("/customer")
    public Flux<Customer> findAll(){
    return customerRepository.findAll().log();
    };
}