package com.autenticaoJWT.demo.controller;

import com.autenticaoJWT.demo.DTO.request.AdminCreateUserRequestDto;
import com.autenticaoJWT.demo.DTO.response.RegisterResponseDto;
import com.autenticaoJWT.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UsuarioService service;

    public AdminController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/create-admin")
    public ResponseEntity<RegisterResponseDto> createAdmin(
            @RequestBody @Valid AdminCreateUserRequestDto dto) {

        return ResponseEntity.ok(service.createAdmin(dto));
    }
}
