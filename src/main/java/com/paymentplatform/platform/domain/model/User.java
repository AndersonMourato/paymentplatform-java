package com.paymentplatform.platform.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public class User {

    private UUID id;
    private String fullName;
    private String email;
    private String document;
    private UserStatus status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public User(UUID id, String fullName, String email, String document, UserStatus status,
                OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.document = document;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getDocument() {
        return document;
    }

    public UserStatus getStatus() {
        return status;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
}
