package com.example.demo.dao;

import com.example.demo.entities.Expense;

import java.util.List;


public interface ExpenseDao {

    void persistExpense(Expense expense);

    Expense getExpense(Long expenseId, Long userId);

    List<Expense> getExpenseByUser(Long userId);

}
