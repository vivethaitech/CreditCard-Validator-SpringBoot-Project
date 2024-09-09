package com.developer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.developer.service.CreditCardValidatorService;

@Controller
public class CreditCardValidatorController {

    @Autowired
    private CreditCardValidatorService service;


    @GetMapping("/validate")
    public String validateCard(@RequestParam Long cardNumber, Model model) {
        if (cardNumber == null) {
            model.addAttribute("result", "Credit card number is required.");
        } else {
            boolean isValid = service.validateCreditCard(cardNumber);
            String result = isValid ? "Valid Credit Card Number" : "Invalid Credit Card Number";
            model.addAttribute("result", result);
        }
        return "index";
    }

    }
    
   

