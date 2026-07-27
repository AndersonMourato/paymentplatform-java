package com.paymentplatform.platform.application.usecase;

import com.paymentplatform.platform.domain.model.User;
import com.paymentplatform.platform.domain.port.out.SaveUserPort;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateUserServiceTest {
    @Test
    void shouldDelegateSaveToOutputPort() {
        SaveUserPort saveUserPort = mock(SaveUserPort.class);
        CreateUserService service = new CreateUserService(saveUserPort);

        User input = new User(UUID.randomUUID(), "Ana Lima", "ana@email.com");
        when(saveUserPort.save(input)).thenReturn(input);

        User result = service.execute(input);

        assertEquals(input, result);
    }
}
