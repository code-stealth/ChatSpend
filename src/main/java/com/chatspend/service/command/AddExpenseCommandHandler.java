package com.chatspend.service.command;

import com.chatspend.model.Expense;
import com.chatspend.service.ExpenseService;
import com.chatspend.common.MessageParser;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddExpenseCommandHandler implements CommandHandler {
    @Autowired
    private ExpenseService expenseService;

    @Override
    public boolean canHandle(String message){
        return MessageParser.startsWith(message, "add ");
    }

    @Override
    public String handle(String message) {
        String[] parts = MessageParser.extractPayload(message).split(" ", 2);
        if(parts.length < 2) {
            return "❌ Invalid format. Try: add <amount> <description>";
        }

        try {
            double amount = Double.parseDouble(parts[0]);
            String description = parts[1];

            Expense expense = new Expense();
            expense.setAmount(amount);
            expense.setDescription(description);

            Expense saved = expenseService.addExpense(expense);
            return "✅ Added ₹" + saved.getAmount() + " for " + saved.getDescription();
        } catch (NumberFormatException e){
            return "❌ Invalid amount. Example: add 100 groceries";
        }
    }
}
