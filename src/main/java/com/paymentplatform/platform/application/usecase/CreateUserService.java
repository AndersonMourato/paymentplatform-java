package com.paymentplatform.platform.application.usecase;

import com.paymentplatform.platform.domain.exception.BusinessException;
import com.paymentplatform.platform.domain.model.User;
import com.paymentplatform.platform.domain.port.in.CreateUserUseCase;
import com.paymentplatform.platform.domain.port.in.UserPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements CreateUserUseCase {

    private final UserPersistencePort persistencePort;

    public CreateUserService(UserPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public User execute(String fullName, String email, String document) {
        persistencePort.findByEmail(email).ifPresent(u -> {
            throw new BusinessException("Email already registered");
        });
        persistencePort.findByDocument(document).ifPresent(u -> {
            throw new BusinessException("Document already registered");
        });
        return persistencePort.save(User.createNew(fullName, email, document));
    }
}
