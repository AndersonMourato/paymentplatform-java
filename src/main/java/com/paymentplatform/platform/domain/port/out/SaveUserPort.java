package com.paymentplatform.platform.domain.port.out;

import com.paymentplatform.platform.domain.model.User;

public interface SaveUserPort {
    User save(User user);
}
