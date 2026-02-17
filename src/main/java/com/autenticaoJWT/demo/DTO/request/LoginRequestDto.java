package com.autenticaoJWT.demo.DTO.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequestDto(@NotEmpty(message = "Email é obrigatorio") String email,
                              @NotEmpty(message = "senha obrigatoria ") String senha) {
}
