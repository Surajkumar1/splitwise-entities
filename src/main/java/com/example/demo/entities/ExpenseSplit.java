package com.example.demo.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExpenseSplit {

    Long expenseId;
    Long userId;
    Double share;

}
