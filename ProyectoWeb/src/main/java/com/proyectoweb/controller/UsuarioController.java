// UserController.java
package com.proyectoweb.controller;

import com.proyectoweb.entity.Usuario;
import com.proyectoweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        List<Usuario> usuarios = userService.getAllUsers();
        model.addAttribute("usuarios", usuarios);
        return "user/list";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        Usuario usuario = userService.getUserById(id);
        model.addAttribute("usuario", usuario);
        return "user/view";
    }

    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "user/form";
    }

    @PostMapping
    public String saveUser(@ModelAttribute Usuario usuario) {
        userService.saveUser(usuario);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
