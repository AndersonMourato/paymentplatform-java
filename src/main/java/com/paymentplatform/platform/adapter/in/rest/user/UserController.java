package com.paymentplatform.platform.adapter.in.rest.user;

import com.paymentplatform.platform.adapter.in.rest.user.dto.CreateUserRequest;
import com.paymentplatform.platform.adapter.in.rest.user.dto.UserResponse;
import com.paymentplatform.platform.domain.model.User;
import com.paymentplatform.platform.domain.port.in.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody CreateUserRequest request) {
        User created = createUserUseCase.execute(
                request.fullName(),
                request.email(),
                request.document()
        );

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(UserResponse.from(created));
    }
}
