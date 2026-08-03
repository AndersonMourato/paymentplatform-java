package com.paymentplatform.platform.domain.port.in;

import com.paymentplatform.platform.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserPersistencePort {
    User save(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    Optional<User> findByDocument(String document);
}
