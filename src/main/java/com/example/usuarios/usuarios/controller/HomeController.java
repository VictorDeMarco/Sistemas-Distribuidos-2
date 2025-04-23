package com.example.usuarios.usuarios.controller;


import com.example.usuarios.usuarios.model.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String mostrarPaginaPrincipal(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuario != null) {
            model.addAttribute("nombre", usuario.getUsername());
        } else {
            model.addAttribute("nombre", "Invitado");
        }
        return "home";
    }
}
