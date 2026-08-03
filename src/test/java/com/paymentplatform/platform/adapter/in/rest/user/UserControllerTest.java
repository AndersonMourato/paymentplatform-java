package com.paymentplatform.platform.adapter.in.rest.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymentplatform.platform.config.SecurityConfig;
import com.paymentplatform.platform.domain.model.User;
import com.paymentplatform.platform.domain.port.in.CreateUserUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import(SecurityConfig.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CreateUserUseCase createUserUseCase;

    @Test
    void shouldReturn201WhenPayloadIsValid() throws Exception {
        when(createUserUseCase.execute(anyString(), anyString(), anyString()))
                .thenReturn(User.createNew("Ana Lima", "ana@email.com", "12345678900"));

        String payload = """
                {
                  \"fullName\": \"Ana Lima\",
                  \"email\": \"ana@email.com\",
                  \"document\": \"12345678900\"
                }
                """;

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isCreated());
    }
}
