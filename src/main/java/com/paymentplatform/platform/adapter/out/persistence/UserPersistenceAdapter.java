package com.paymentplatform.platform.adapter.out.persistence;

import com.paymentplatform.platform.adapter.out.persistence.jpa.UserSpringDataRepository;
import com.paymentplatform.platform.adapter.out.persistence.mapper.UserPersistenceMapper;
import com.paymentplatform.platform.domain.model.User;
import com.paymentplatform.platform.domain.port.in.UserPersistencePort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserSpringDataRepository repository;
    private final UserPersistenceMapper mapper;

    public UserPersistenceAdapter(UserSpringDataRepository repository) {
        this.repository = repository;
        this.mapper = new UserPersistenceMapper();
    }

    @Override
    public User save(User user) {
        return mapper.toDomain(repository.save(mapper.toEntity(user)));
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByDocument(String document) {
        return repository.findByDocument(document).map(mapper::toDomain);
    }
}
