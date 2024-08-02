package com.proyectoweb.controller;

import com.proyectoweb.entity.OrdenCompra;
import com.proyectoweb.service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping
    public String listOrdenes(Model model) {
        model.addAttribute("ordenes", ordenCompraService.findAll());
        return "ordenes"; // Nombre del template Thymeleaf para la lista de órdenes
    }

    @GetMapping("/{id}")
    public String getOrden(@PathVariable Long id, Model model) {
        Optional<OrdenCompra> orden = ordenCompraService.findById(id);
        if (orden.isPresent()) {
            model.addAttribute("orden", orden.get());
            return "orden-detalle"; // Nombre del template Thymeleaf para el detalle de la orden
        } else {
            return "404";
        }
    }

    @PostMapping("/create")
    public String createOrden(@ModelAttribute OrdenCompra ordenCompra) {
        ordenCompraService.save(ordenCompra);
        return "redirect:/ordenes";
    }
}
