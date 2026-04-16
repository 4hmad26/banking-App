package com.ahmad.banking_app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ahmad.banking_app.entity.Account;
import com.ahmad.banking_app.service.AccountService;
import java.util.Map;
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService service;


    @PostMapping
    public  Account create (@RequestBody Account account ){
       return service.createAccount(account);
    }
    @GetMapping("/{id}")
    public Account get (@PathVariable Long id ){
        return service.getAccount(id);
    }
    @PostMapping("/{id}/deposit")
    public Account deposit (@PathVariable Long id , @RequestParam double amount){
        return service.deposit(id , amount);
    }
    @PostMapping("/{id}/withdraw")
    public Account withdraw (@PathVariable Long id , @RequestParam double amount){
        return service.withdraw(id,amount);
    }
    @PutMapping("/{id}")
    public Account updateBalance(@PathVariable Long id , @RequestParam double amount){
        return service.updateBalance(id, amount);
    }
    @PostMapping("/transfer")
    public String transfer(@RequestBody Map<String, Object> data) {

        Long fromId = Long.valueOf(data.get("fromId").toString());
        Long toId = Long.valueOf(data.get("toId").toString());
        double amount = Double.parseDouble(data.get("amount").toString());

        service.transfer(fromId, toId, amount);

        return "Transfer successful";
    }
}
