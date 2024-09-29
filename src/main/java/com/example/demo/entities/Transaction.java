package com.example.demo.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Transaction {

    Long fromUserId;
    Long toUserId;
    Double amountPaid;

}
