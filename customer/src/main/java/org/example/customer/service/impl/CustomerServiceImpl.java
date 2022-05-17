package org.example.customer.service.impl;

import lombok.AllArgsConstructor;
import org.example.customer.model.Customer;
import org.example.customer.model.CustomerRegistrationRequest;
import org.example.customer.repository.CustomerRepository;
import org.example.customer.service.CustomerService;
import org.example.fraud.model.FraudResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Customer register(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder().
                firstName(request.firstName()).
                lastName(request.lastName()).
                email(request.email()).
                build();
        customerRepository.saveAndFlush(customer);
        FraudResponse response = restTemplate.getForObject(
                "http://localhost:8081/api/v1/frauds/{customerID}",
                FraudResponse.class,
                customer.getId()
        );
        if (response.isFraudster()) throw new IllegalArgumentException();
        return customerRepository.save(customer);
    }
}
