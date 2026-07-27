package com.paymentplatform.platform.domain.port.in;

import com.paymentplatform.platform.domain.model.User;

public interface CreateUserUseCase {
    User execute(User user);
}
