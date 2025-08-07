package com.chatspend.service;

import com.chatspend.model.Expense;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {
    private final List<Expense> expenses = new ArrayList<>();
    private Long nextId = 1L;

    public Expense addExpense(Expense expense){
        expense.setId(nextId++);
        expense.setTimestamp(java.time.LocalDateTime.now());
        expenses.add(expense);
        return expense;
    }

    public List<Expense> getAllExpenses(){
        return expenses;
    }
}
