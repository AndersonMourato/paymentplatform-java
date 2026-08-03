package com.paymentplatform.platform.application.usecase;

import com.paymentplatform.platform.domain.exception.BusinessException;
import com.paymentplatform.platform.domain.model.User;
import com.paymentplatform.platform.domain.port.in.UserPersistencePort;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreateUserServiceTest {

    @Test
    void shouldCreateUserWhenEmailAndDocumentAreUnique() {
        UserPersistencePort port = mock(UserPersistencePort.class);
        CreateUserService service = new CreateUserService(port);

        when(port.findByEmail("ana@email.com")).thenReturn(Optional.empty());
        when(port.findByDocument("12345678900")).thenReturn(Optional.empty());
        when(port.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User result = service.execute("Ana Lima", "ana@email.com", "12345678900");

        assertTrue(result.getId() != null);
    }

    @Test
    void shouldThrowWhenEmailAlreadyExists() {
        UserPersistencePort port = mock(UserPersistencePort.class);
        CreateUserService service = new CreateUserService(port);

        when(port.findByEmail("ana@email.com")).thenReturn(Optional.of(User.createNew("Ana", "ana@email.com", "12345678900")));

        assertThrows(BusinessException.class,
                () -> service.execute("Ana", "ana@email.com", "99999999999"));
    }
}
