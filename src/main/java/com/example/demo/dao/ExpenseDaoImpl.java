package com.example.demo.dao;

import com.example.demo.entities.Expense;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Qualifier("ExpenseDaoImpl")
public class ExpenseDaoImpl implements ExpenseDao {

    Map<Long, List<Expense>> expenseMap = new HashMap<>();

    public void persistExpense(Expense expense){
        List<Expense> expenses = expenseMap.getOrDefault(expense.getLentBy(), new ArrayList<>());
        expenseMap.put(expense.getLentBy(), expenses);
    }

    public Expense getExpense(Long expenseId, Long userId){
        if(expenseMap.containsKey(userId)){
            return expenseMap.get(userId).stream().filter(expense -> expenseId.equals(expense.getId())).findFirst().get();
        }
        return null;
    }

    public List<Expense> getExpenseByUser(Long userId){
        return expenseMap.get(userId);
    }

}
