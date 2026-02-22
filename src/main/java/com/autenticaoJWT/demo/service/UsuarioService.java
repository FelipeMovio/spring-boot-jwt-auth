package com.autenticaoJWT.demo.service;

import com.autenticaoJWT.demo.DTO.request.RegisterRequestDto;
import com.autenticaoJWT.demo.DTO.response.RegisterResponseDto;
import com.autenticaoJWT.demo.model.Role;
import com.autenticaoJWT.demo.model.Usuario;
import com.autenticaoJWT.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;


    private final PasswordEncoder passwordEncoder;


    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public RegisterResponseDto register(RegisterRequestDto dto) {
        if (usuarioRepository.findByEmail(dto.email()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado!");
        }


        Usuario newUser = Usuario.builder()
                .nome(dto.nome())
                .email(dto.email())
                .senha(passwordEncoder.encode(dto.senha()))
                .roles(Set.of(Role.ROLE_USER))
                .build();

        Usuario saved = usuarioRepository.save(newUser);

        return new RegisterResponseDto(saved.getNome(),saved.getEmail());
    }



}
