package com.autenticaoJWT.demo.repository;

import com.autenticaoJWT.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository< Usuario, Long> {
}
