package com.ahmad.banking_app.repository;

import com.ahmad.banking_app.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

