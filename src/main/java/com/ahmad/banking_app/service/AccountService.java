package com.ahmad.banking_app.service;
import com.ahmad.banking_app.entity.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.ahmad.banking_app.entity.Account;
import com.ahmad.banking_app.repository.AccountRepository;
import com.ahmad.banking_app.repository.TransactionRepository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

import java.util.Optional;


@Service
public class AccountService {
    @Autowired

    private TransactionRepository transactionRepo;
    @Autowired
    private AccountRepository repo;

    public Account createAccount(Account account) {
        return repo.save(account);
    }

    public Account getAccount(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Account deposit(Long id, double amount) {
        Account acc = getAccount(id);
        if (acc.getBalance() < amount) {
            throw new
                    RuntimeException("Insufficient Balance");
        }
        acc.setBalance(acc.getBalance() + amount);
        return repo.save(acc);
    }

    public Account withdraw(Long id, double amount) {
        Account acc = repo.findById(id).orElseThrow(() -> new
                RuntimeException("Account not found "));

        if (acc.getBalance() < amount) {
            throw new
                    RuntimeException("Insufficient Balance");
        }
        acc.setBalance(acc.getBalance() - amount);
        return repo.save(acc);
    }

    public Account updateBalance(Long id, double amount) {
        Account acc = repo.findById(id).orElseThrow(() -> new
                RuntimeException("Account not found "));
        acc.setBalance(amount);
        return repo.save(acc);


    }
    @Transactional
    public void transfer(Long fromId, Long toId, double amount) {

        Account fromAccount = repo.findById(fromId)
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        Account toAccount = repo.findById(toId)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        // Deduct
        fromAccount.setBalance(fromAccount.getBalance() - amount);

        // Add
        toAccount.setBalance(toAccount.getBalance() + amount);

        repo.save(fromAccount);
        repo.save(toAccount);


        Transaction tx = new Transaction();
        tx.setFromAccountId(fromId);
        tx.setToAccountId(toId);
        tx.setAmount(amount);
        tx.setTime(LocalDateTime.now());

        transactionRepo.save(tx);
    }
}