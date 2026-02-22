package com.autenticaoJWT.demo.DTO.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequestDto(

        @Email(message = "Email inválido")
        @NotBlank(message = "Email é obrigatório")
        String email,

        @NotBlank(message = "Senha obrigatória")
        String senha,

        @NotBlank(message = "Nome obrigatório")
        String nome
) {}
