package com.chatspend.service.command;

import com.chatspend.controller.ExpenseController;
import com.chatspend.model.Expense;
import com.chatspend.service.ExpenseService;
import com.chatspend.common.MessageParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListExpenseCommandHandler implements CommandHandler{
    @Autowired
    private ExpenseService expenseService;

    @Override
    public boolean canHandle(String message){
        return MessageParser.startsWith(message, "get expenses") ||
                MessageParser.startsWith(message, "list expenses");
    }

    @Override
    public String handle(String message) {
        List<Expense> expenses = expenseService.getAllExpenses();
        if (expenses.isEmpty()) return "📭 No expenses recorded yet.";

        StringBuilder sb = new StringBuilder("📋 Your Expenses:\n");
        double total = 0.0;
        int count = 1;

        for (Expense e : expenses) {
            sb.append(count++)
                    .append(". ₹")
                    .append(e.getAmount())
                    .append(" - ")
                    .append(e.getDescription())
                    .append(" (")
                    .append(e.getTimestamp())
                    .append(")\n");

            total += e.getAmount();
        }

        sb.append("Total: ₹").append(total);
        return sb.toString();
    }
}
