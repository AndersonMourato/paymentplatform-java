package com.paymentplatform.platform.domain.port.in;

import com.paymentplatform.platform.domain.model.User;

public interface CreateUserUseCase {
    User execute(String fullName, String email, String document);
}
