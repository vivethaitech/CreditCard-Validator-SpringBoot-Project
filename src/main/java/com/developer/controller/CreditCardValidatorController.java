package com.developer.controller;

import com.developer.service.CreditCardValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreditCardValidatorController {

    @Autowired
    private CreditCardValidatorService validatorService;

    @GetMapping("/")
    public String index() {
        return "index"; // This should match the file under 'static' folder
    }

    @GetMapping("/validate")
    @ResponseBody
    public String validateCard(@RequestParam("cardNumber") long cardNumber) {
        boolean isValid = validatorService.validateCreditCard(cardNumber);
        return isValid ? "Valid Credit Card Number" : "Invalid Credit Card Number";
    }
    
   
}
