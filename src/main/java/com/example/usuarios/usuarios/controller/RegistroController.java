package com.example.usuarios.usuarios.controller;
import com.example.usuarios.usuarios.model.Usuario;
import com.example.usuarios.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/register")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    @PostMapping("/register")
    public String procesarRegistro(@ModelAttribute Usuario usuario, Model model) {
        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            model.addAttribute("error", "El nombre de usuario ya existe");
            return "register";
        }


        usuarioRepository.save(usuario);
        model.addAttribute("mensaje", "Usuario registrado correctamente");
        return "register"; // Redirigir al login tras registrarse
    }
}

