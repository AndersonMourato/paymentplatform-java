package com.paymentplatform.platform.application.usecase;

import com.paymentplatform.platform.domain.model.User;
import com.paymentplatform.platform.domain.port.in.CreateUserUseCase;
import com.paymentplatform.platform.domain.port.out.SaveUserPort;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements CreateUserUseCase {

    private final SaveUserPort saveUserPort;

    public CreateUserService(SaveUserPort saveUserPort) {
        this.saveUserPort = saveUserPort;
    }

    @Override
    public User execute(User user) {
        return saveUserPort.save(user);
    }
}
