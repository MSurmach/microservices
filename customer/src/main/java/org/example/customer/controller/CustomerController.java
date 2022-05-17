package org.example.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.customer.model.Customer;
import org.example.customer.model.CustomerRegistrationRequest;
import org.example.customer.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
@Slf4j
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public Customer registerCustomer(@RequestBody CustomerRegistrationRequest request) {
        log.info("IN registerCustomer() " + request);
        Customer registered = customerService.register(request);
        log.info("OUT registerCount() - registered customer:" + registered);
        return registered;
    }
}
