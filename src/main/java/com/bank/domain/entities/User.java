package com.bank.domain.entities;

public class User {
    private int userId;
    private String fullName;
    private String identificationId;
    private String email;
    private String userStatus; // Active, Inactive, Blocked
    private String role;

    // Getters and Setters
    public String getUserStatus() { return userStatus; }
    public void setUserStatus(String status) { this.userStatus = status; }
}