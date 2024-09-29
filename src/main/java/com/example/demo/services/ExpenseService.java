package com.example.demo.services;

import com.example.demo.entities.Expense;
import com.example.demo.entities.ExpenseSplit;
import com.example.demo.entities.User;
import com.example.demo.enums.AmountType;
import com.example.demo.enums.SplitType;
import com.example.demo.dao.ExpenseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

public class ExpenseService {


    @Autowired
    @Qualifier("ExpenseDaoImpl")
    ExpenseDao expenseDao;

    public void createExpense(Expense expense){
        expenseDao.persistExpense(expense);
    }

    public double computeBalance(User user1, User user2){
        Double amountLent = computeAmountLent(user1.getUserId(), user2.getUserId());
        Double amountBorrowed = computeAmountLent(user2.getUserId(), user1.getUserId());
        if(amountLent == amountBorrowed){
            System.out.println("Expenses are settled up");
        } else if(amountLent > amountBorrowed){
            System.out.println(user2.getUserName() + " owes " + user1.getUserName() + " - rs." + (amountLent - amountBorrowed));
        } {
            System.out.println(user1.getUserName() + " owes " + user2.getUserName() + " - rs." + (amountBorrowed - amountLent));
        }
        return amountLent -  amountBorrowed;
    }

    public Double computeAmountLent(Long user1, Long user2) {
        List<Expense> userExpenses = expenseDao.getExpenseByUser(user1);
        double amountLent = 0.0;
        for (Expense expense : userExpenses) {
            Optional<ExpenseSplit> expenseSplit = expense.getSplits().stream().filter(split -> split.getUserId().equals(user2)).findAny();
            if (expenseSplit.isPresent()) {
                if (expense.getSplitType().equals(SplitType.EQUALLY)) {
                    amountLent += expense.getAmount() / expense.getSplits().size();
                } else {
                    if (expense.getAmountType().equals(AmountType.FLAT)) {
                        amountLent += expenseSplit.get().getShare();
                    } else {
                        amountLent += expense.getAmount() * (expenseSplit.get().getShare() / 100);
                    }
                }
            }
        }
        return amountLent;
    }


}
