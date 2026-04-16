package com.ahmad.banking_app.entity;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Entity

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonProperty("balance")
    private double balance;

    public Account(){}

    public Long getId(){
        return id;
    }
    public String getName (){
        return name ;
    }
    public void setName (String name ){
        this.name = name;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

}
