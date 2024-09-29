package com.example.demo.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {

    Long userId;
    String userName;
    String emailId;
    String phoneNo;

}
