package com.autenticaoJWT.demo.controller;

import com.autenticaoJWT.demo.DTO.request.LoginRequestDto;
import com.autenticaoJWT.demo.DTO.request.RegisterRequestDto;
import com.autenticaoJWT.demo.DTO.response.LoginResponseDto;
import com.autenticaoJWT.demo.DTO.response.RegisterResponseDto;
import com.autenticaoJWT.demo.model.Usuario;
import com.autenticaoJWT.demo.security.TokenConfig;
import com.autenticaoJWT.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenConfig tokenConfig;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto) {
        RegisterResponseDto user = service.register(dto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto dto) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.email(), dto.senha())
        );
        Usuario user = (Usuario) auth.getPrincipal();
        String token = tokenConfig.generateToken(user);
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

}
