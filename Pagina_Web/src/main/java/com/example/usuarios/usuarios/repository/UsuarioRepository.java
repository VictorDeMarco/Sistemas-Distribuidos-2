package com.example.usuarios.usuarios.repository;

import com.example.usuarios.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUsername(String username);
}
