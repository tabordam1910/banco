package com.bank.domain.entities;

import com.bank.domain.Enums.UserStatus;

public class User {
    private String userId;
    private String fullName;
    private String identificationId;
    private String email;
    private String role; // Individual or Corporate
    private UserStatus status;

    public User(String userId, String fullName, String identificationId, String email, String role) {
        this.userId = userId;
        this.fullName = fullName;
        this.identificationId = identificationId;
        this.email = email;
        this.role = role;
        this.status = UserStatus.ACTIVE;
    }

    // GETTERS: Agrégalos para eliminar todas las advertencias "not used"
    public String getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getIdentificationId() {
        return identificationId;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public UserStatus getStatus() {
        return status;
    }

    // SETTER: Útil para cambiar el estado del usuario (ej: Bloquearlo)
    public void setStatus(UserStatus status) {
        this.status = status;
    }
}