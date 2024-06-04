package com.example.turismWork.service;

import com.example.turismWork.entities.Transaction;
import com.example.turismWork.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}