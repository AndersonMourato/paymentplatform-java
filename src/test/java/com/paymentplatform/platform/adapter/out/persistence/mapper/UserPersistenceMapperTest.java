package com.paymentplatform.platform.adapter.out.persistence.mapper;

import com.paymentplatform.platform.adapter.out.persistence.jpa.UserJpaEntity;
import com.paymentplatform.platform.domain.model.User;
import com.paymentplatform.platform.domain.model.UserStatus;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserPersistenceMapperTest {

    @Test
    void shouldMapDomainToEntityAndBack() {
        User original = new User(
            UUID.randomUUID(),
            "Ana Lima",
            "ana@email.com",
            "12345678900",
            UserStatus.ACTIVE,
            OffsetDateTime.now(),
            OffsetDateTime.now()
        );

        UserPersistenceMapper mapper = new UserPersistenceMapper();
        UserJpaEntity entity = mapper.toEntity(original);
        User mapped = mapper.toDomain(entity);

        assertEquals(original.getId(), mapped.getId());
        assertEquals(original.getEmail(), mapped.getEmail());
        assertEquals(original.getDocument(), mapped.getDocument());
    }
}
