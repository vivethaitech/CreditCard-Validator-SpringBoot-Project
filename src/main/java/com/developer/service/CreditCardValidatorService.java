package com.developer.service;

import org.springframework.stereotype.Service;
@Service
public class CreditCardValidatorService {

    public boolean validateCreditCard(long num) {
        int[] a = new int[String.valueOf(num).length()];

        for (int i = a.length - 1; i >= 0; i--) {
            a[i] = (int)(num % 10);
            num = num / 10;
        }

        for (int i = 0; i < a.length; i += 2) {
            a[i] = a[i] * 2;
            if (a[i] > 9) {
                a[i] = a[i] - 9;
            }
        }

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        return (sum % 10 == 0);
    }
}
