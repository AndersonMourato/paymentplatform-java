package com.paymentplatform.platform.domain.model;

import java.util.UUID;

public class User {

    private UUID id;
    private String fullName;
    private String email;

    public User(UUID id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }
}
