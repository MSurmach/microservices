package org.example.customer.service;

import org.example.customer.model.Customer;
import org.example.customer.model.CustomerRegistrationRequest;

public interface CustomerService {
    Customer register(CustomerRegistrationRequest request);
}
