package org.example.fraud.controller;

import lombok.AllArgsConstructor;
import org.example.fraud.model.FraudResponse;
import org.example.fraud.service.FraudService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraudsters")
@AllArgsConstructor
public class FraudController {

    private final FraudService fraudService;

    @GetMapping(path = "{customerId}")
    public FraudResponse isFraudster(@PathVariable int customerId) {
        return new FraudResponse(fraudService.isFradulentCustomer(customerId));
    }
}
