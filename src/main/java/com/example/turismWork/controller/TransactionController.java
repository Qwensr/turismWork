package com.example.turismWork.controller;

import com.example.turismWork.entities.Attraction;
import com.example.turismWork.entities.Transaction;
import com.example.turismWork.entities.User;
import com.example.turismWork.service.TransactionService;
import com.example.turismWork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    @PostMapping("/attraction/{id}/book")
    public String bookAttraction(@PathVariable Long id, @RequestParam double amount, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Transaction transaction = new Transaction();
        transaction.setAttraction(new Attraction(id));
        transaction.setUser(user);
        transaction.setAmount(amount);
        transaction.setTransactionDate(new Date());
        transactionService.save(transaction);
        return "redirect:/attraction/" + id + "/confirmation";
    }
}