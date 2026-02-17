package com.autenticaoJWT.demo.service;

import com.autenticaoJWT.demo.model.Usuario;
import com.autenticaoJWT.demo.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;



public class AuthService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
