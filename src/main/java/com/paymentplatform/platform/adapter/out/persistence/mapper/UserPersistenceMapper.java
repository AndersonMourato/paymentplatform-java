package com.paymentplatform.platform.adapter.out.persistence.mapper;

import com.paymentplatform.platform.adapter.out.persistence.jpa.UserJpaEntity;
import com.paymentplatform.platform.domain.model.User;

public class UserPersistenceMapper {
    public UserJpaEntity toEntity(User user) {
        UserJpaEntity entity = new UserJpaEntity();
        entity.setId(user.getId());
        entity.setFullName(user.getFullName());
        entity.setEmail(user.getEmail());
        entity.setDocument(user.getDocument());
        entity.setStatus(user.getStatus());
        entity.setCreatedAt(user.getCreatedAt());
        entity.setUpdatedAt(user.getUpdatedAt());
        return entity;
    }

    public User toDomain(UserJpaEntity entity) {
        return new User(
                entity.getId(),
                entity.getFullName(),
                entity.getEmail(),
                entity.getDocument(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
