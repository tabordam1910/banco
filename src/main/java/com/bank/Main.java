package com.bank;

import com.bank.application.UserService;
import com.bank.domain.entities.BankAccount;
import com.bank.domain.entities.Loan;
import com.bank.domain.entities.User;
import com.bank.domain.services.LoanDomainService;
import com.bank.domain.services.TransferDomainService;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize Services
        UserService userService = new UserService();
        LoanDomainService loanService = new LoanDomainService();
        TransferDomainService transferService = new TransferDomainService();

        try {
            System.out.println("========================================");
            System.out.println("   BANKING SYSTEM CORE SIMULATION       ");
            System.out.println("========================================\n");

            // 2. Create Users (Client and Internal Analyst)
            User client = new User("USR-101", "John Doe", "ID-778899", "john.doe@email.com", "CLIENT");
            User analyst = new User("ADM-001", "Jane Smith", "ID-112233", "jane.smith@bank.com", "INTERNAL_ANALYST");
            
            userService.createClient(client);
            System.out.println("[Step 1] Client registered: " + client.getFullName());

            // 3. Create Bank Account using the (String, String, String) constructor
            BankAccount clientAccount = new BankAccount("ACC-5500", "SAVINGS", client.getUserId());
            clientAccount.setBalance(new BigDecimal("1200.50"));
            System.out.println("[Step 2] Account created for " + client.getFullName() + " with balance: $" + clientAccount.getBalance());

            // 4. Create a Loan Request
            BigDecimal loanAmount = new BigDecimal("15000.00");
            Loan personalLoan = new Loan("LOAN-B-99", loanAmount);
            System.out.println("\n[Step 3] New Loan Request: " + personalLoan.getLoanId());
            System.out.println("   - Requested Amount: $" + personalLoan.getAmountApproved());
            System.out.println("   - Current Status: " + personalLoan.getStatus());

            // 5. Analyst Review Process (Approval)
            System.out.println("\n[Step 4] Analyst " + analyst.getFullName() + " is reviewing the loan...");
            loanService.approveLoan(personalLoan, analyst.getUserId());
            System.out.println("   - New Loan Status: " + personalLoan.getStatus());

            // 6. Execute Disbursement (Transfer money to the account)
            System.out.println("\n[Step 5] Executing disbursement to account: " + clientAccount.getAccountNumber());
            loanService.executeDisbursement(personalLoan, clientAccount, analyst.getUserId());

            // 7. Final Results
            System.out.println("\n========================================");
            System.out.println("           FINAL SUMMARY                ");
            System.out.println("========================================");
            System.out.println("Client: " + client.getFullName());
            System.out.println("Loan Final Status: " + personalLoan.getStatus());
            System.out.println("Updated Account Balance: $" + clientAccount.getBalance());
            System.out.println("========================================\n");

            // 8. Testing Transfer Logic
            System.out.println("[Step 6] Testing a small transfer of $200.00...");
            BankAccount destinationAccount = new BankAccount("ACC-9999", "SAVINGS", "OTHER-01");
            transferService.processTransfer(clientAccount, destinationAccount, new BigDecimal("200.00"), client.getUserId());
            System.out.println("   - Transfer Successful.");
            System.out.println("   - Remaining Balance: $" + clientAccount.getBalance());

        } catch (Exception e) {
            System.err.println("\n[CRITICAL ERROR] Operation failed: " + e.getMessage());
        }
    }
}