package com.ahmad.banking_app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ahmad.banking_app.entity.Account;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ahmad.banking_app.entity.Transaction;



public interface AccountRepository extends JpaRepository<Account,Long>{
}
