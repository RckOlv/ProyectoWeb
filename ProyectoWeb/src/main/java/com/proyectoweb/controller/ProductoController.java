package com.proyectoweb.controller;

import com.proyectoweb.entity.Producto;
import com.proyectoweb.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String listProductos(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "products"; // Nombre del template Thymeleaf para la lista de productos
    }

    @GetMapping("/{id}")
    public String getProducto(@PathVariable Long id, Model model) {
        Optional<Producto> producto = productoService.findById(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "producto-detalle"; // Nombre del template Thymeleaf para el detalle del producto
        } else {
            return "404"; // Nombre del template Thymeleaf para página no encontrada
        }
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto-form"; // Nombre del template Thymeleaf para el formulario de creación
    }

    @PostMapping("/create")
    public String createProducto(@ModelAttribute Producto producto) {
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Producto> producto = productoService.findById(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "producto-form"; // Nombre del template Thymeleaf para el formulario de edición
        } else {
            return "404";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateProducto(@PathVariable Long id, @ModelAttribute Producto producto) {
        producto.setId_producto(id);
        productoService.save(producto);
        return "redirect:/products";
    }

    @PostMapping("/delete/{id}")
    public String deleteProducto(@PathVariable Long id) {
        productoService.deleteById(id);
        return "redirect:/products";
    }
}
