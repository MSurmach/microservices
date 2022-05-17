package org.example.fraud.repository;

import org.example.fraud.model.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<Fraud, Integer> {
}
