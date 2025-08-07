package com.chatspend.model;
import java.time.LocalDateTime;

public class Expense {
    private Long id;
    private double amount;
    private String description;
    private LocalDateTime timestamp;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp){
        this.timestamp = timestamp;
    }
}
