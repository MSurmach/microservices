package org.example.fraud.service.impl;

import org.example.fraud.model.Fraud;
import org.example.fraud.repository.FraudRepository;
import org.example.fraud.service.FraudService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudServiceImpl implements FraudService {

    private final FraudRepository fraudRepository;

    public FraudServiceImpl(FraudRepository fraudRepository) {
        this.fraudRepository = fraudRepository;
    }

    @Override
    public boolean isFradulentCustomer(Integer customerId) {
        fraudRepository.save(Fraud.builder().
                isFraudster(false).
                customerId(customerId).
                createdAt(LocalDateTime.now()).
                build());
        return false;
    }
}
