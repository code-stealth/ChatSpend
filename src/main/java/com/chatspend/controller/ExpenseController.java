package com.chatspend.controller;

import com.chatspend.service.ExpenseService;
import com.chatspend.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping("/add")
    public Expense addExpense(@RequestBody Expense expense){
        return expenseService.addExpense(expense);
    }

    @GetMapping("/all")
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }
}
