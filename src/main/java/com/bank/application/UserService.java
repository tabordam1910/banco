package com.bank.application;

import com.bank.domain.entities.BankAccount;

public class UserService {
    public void displayUserProfile(BankAccount account) {
        System.out.println("======= USER PROFILE =======");
        System.out.println("Holder: " + account.getHolderName()); // Ya no marcará error
        System.out.println("Account: " + account.getAccountNumber());
        System.out.println("Status: " + account.getStatus());
        System.out.println("============================");
    }
}