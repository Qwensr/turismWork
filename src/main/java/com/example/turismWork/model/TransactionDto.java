package com.example.turismWork.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class TransactionDto {
    private Long id;
    private Long userId;
    private Long attractionId;
    private double amount;
    private Date transactionDate;
}
