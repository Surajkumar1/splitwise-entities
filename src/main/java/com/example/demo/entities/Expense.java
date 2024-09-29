package com.example.demo.entities;

import com.example.demo.enums.AmountType;
import com.example.demo.enums.SplitType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class Expense {

    Long id;
    Long createdBy;
    Long lentBy;
    Double amount;
    Date createdTime;
    SplitType splitType;
    AmountType amountType;
    List<ExpenseSplit> splits;

}
