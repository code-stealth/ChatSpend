package com.chatspend.service;

//import com.chatspend.model.Expense;
import com.chatspend.service.command.CommandRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.List;

//@Service
//public class WhatsappService {
//    private final ExpenseService expenseService;
//
//    @Autowired
//    public WhatsappService(ExpenseService expenseService) {
//        this.expenseService = expenseService;
//    }
//
//    public String processIncomingMessage(String message){
//        message = message.trim().toLowerCase();
//
//        if(message.startsWith("add ")){
//            String[] parts = message.substring(4).split(" ", 2);
//            if(parts.length < 2){
//                return "Invalid format. Please use: add <amount> <description>";
//            }
//            try{
//                double amount = Double.parseDouble(parts[0]);
//                String description = parts[1];
//
//                Expense expense = new Expense();
//                expense.setAmount(amount);
//                expense.setDescription(description);
//                Expense savedExpense = expenseService.addExpense(expense);
//
//                return "✅ Expense added:\n₹" + savedExpense.getAmount() + " for " + savedExpense.getDescription();
//            } catch (NumberFormatException e){
//                return "❌ Invalid amount.\nRequired format: add <amount> <description>.\nExample: add 100 groceries";
//            }
//        }
//        else if(message.equals("get expenses") || message.equals("list expenses")){
//            List<Expense> allExpenses = expenseService.getAllExpenses();
//            if(allExpenses.isEmpty()){
//                return "📭 No expenses recorded yet.";
//            }
//
//            StringBuilder response = new StringBuilder("📋 Your Expenses:\n");
//            double total = 0.0;
//            int count = 1;
//
//            for(Expense e: allExpenses){
//                response.append(count++)
//                        .append(". ₹")
//                        .append(e.getAmount())
//                        .append(" - ")
//                        .append(e.getDescription())
//                        .append(" (")
//                        .append(e.getTimestamp())
//                        .append(")\n");
//                total += e.getAmount();
//            }
//
//            response.append("Total: ₹").append(total);
//            return response.toString();
//        }
//        return "🤖 I didn't understand that.\nRequired format: add <amount> <description>. Try:\n- add 100 groceries\n- add 50 travel";
//    }
//}

@Service
public class WhatsappService {
    private final CommandRouter commandRouter;

    @Autowired
    public WhatsappService(CommandRouter commandRouter){
        this.commandRouter = commandRouter;
    }

    public String processIncomingMessage(String message){
        return commandRouter.route(message);
    }
}