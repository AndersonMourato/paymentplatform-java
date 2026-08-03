package com.paymentplatform.platform.adapter.in.rest.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "Nome é obrigatorio")
        @Size(min = 3, max = 120, message = "Nome precisa ter entre 3 e 120 caracteres")
        String fullName,

        @NotBlank(message = "Email é obrigatorio")
        @Email(message = "Formato de email inválido")
        String email,

        @NotBlank(message = "Documento é obrigatorio")
        @Pattern(regexp = "^[0-9]{11}$", message = "Documento deve conter 11 dígitos")
        String document
) {
}
