package com.bank.application;

import com.bank.domain.entities.BankAccount;

/**
 * Service responsible for user-related application logic.
 */
public class UserService {

    /**
     * Displays the profile information of the account holder.
     * Uses the getters from the BankAccount entity.
     */
    public void displayUserProfile(BankAccount account) {
        System.out.println("======= USER PROFILE =======");
        // Estos métodos deben existir en BankAccount.java
        System.out.println("Holder Name: " + account.getHolderName());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Current Balance: $" + account.getBalance());
        System.out.println("Account Status: " + account.getStatus());
        System.out.println("============================");
    }
}