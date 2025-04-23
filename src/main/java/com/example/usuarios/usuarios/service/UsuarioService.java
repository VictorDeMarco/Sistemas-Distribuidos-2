package com.example.usuarios.usuarios.service;


import com.example.usuarios.usuarios.model.Usuario;
import com.example.usuarios.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository  usuarioRepository ;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario autenticar(String username, String password) {
        return usuarioRepository.findByUsername(username)
                .filter(usuario -> usuario.getPassword().equals(password))
                .orElse(null);
    }
}
