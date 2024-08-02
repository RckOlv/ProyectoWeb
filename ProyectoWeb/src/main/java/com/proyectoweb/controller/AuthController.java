package com.proyectoweb.controller;

import com.proyectoweb.entity.Usuario;
import com.proyectoweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Nombre del template Thymeleaf para la vista de inicio de sesión
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Aquí agregar lógica de autenticación
        return "redirect:/home"; // Redirige a la página principal después del inicio de sesión
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // Nombre del template Thymeleaf para el registro
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Usuario usuario) {
        usuarioService.saveUser(usuario);
        return "redirect:/login"; // Redirige a la página de inicio de sesión después del registro
    }
}
