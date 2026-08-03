package com.paymentplatform.platform.adapter.in.rest.user.dto;

import com.paymentplatform.platform.domain.model.User;

import java.time.OffsetDateTime;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String fullName,
        String email,
        String document,
        String status,
        OffsetDateTime createdAt
) {

    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getDocument(),
                user.getStatus().name(),
                user.getCreatedAt()
        );
    }
}
