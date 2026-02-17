package com.autenticaoJWT.demo.DTO.request;

import com.autenticaoJWT.demo.model.Role;
import jakarta.validation.constraints.NotEmpty;

public record RegisterRequestDto(@NotEmpty(message = "Email é obrigatorio") String email,
                                 @NotEmpty(message = "senha obrigatoria ") String senha ,
                                 @NotEmpty(message = "nome obrigatorio") String nome,
                                 Role role) {
}
