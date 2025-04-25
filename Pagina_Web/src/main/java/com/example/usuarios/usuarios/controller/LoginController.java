package com.example.usuarios.usuarios.controller;

import com.example.usuarios.usuarios.model.Usuario;
import com.example.usuarios.usuarios.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    int contador = 0;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String username,
                                @RequestParam String password,
                                Model model,
                                HttpSession session) {
        Usuario usuario = usuarioService.autenticar(username, password);

        if (usuario != null) {
            session.setAttribute("usuarioLogueado", usuario);
           contador = 0;
            return "redirect:/home";
        } else {
            if (contador < 3) {
                model.addAttribute("error", "Usuario o contraseña incorrectos");
                contador++;
                return "login";
            } else {
                model.addAttribute("error", "Compruebe el documento README asociado al proyecto para conocer un usuario y contraseña validos ");
                return "login";
            }

        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}

