package com.proyectoweb.controller;

import com.proyectoweb.entity.Carrito;
import com.proyectoweb.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public String viewCarrito(Model model) {
        // Suponiendo que el carrito es asociado al usuario actual
        // Debes implementar la lógica para obtener el carrito del usuario actual
        Long userId = 1L; // Obtener el ID del usuario actual
        Optional<Carrito> carrito = carritoService.findById(userId);
        if (carrito.isPresent()) {
            model.addAttribute("carrito", carrito.get());
            return "carrito"; // Nombre del template Thymeleaf para la vista del carrito
        } else {
            return "404";
        }
    }

    @PostMapping("/add/{id}")
    public String addProductoToCarrito(@PathVariable Long id, @RequestParam int cantidad) {
        // Implementa la lógica para agregar el producto al carrito
        return "redirect:/carrito";
    }

    @PostMapping("/remove/{id}")
    public String removeProductoFromCarrito(@PathVariable Long id) {
        // Implementa la lógica para eliminar el producto del carrito
        return "redirect:/carrito";
    }
}
