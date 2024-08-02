package com.proyectoweb.service;

import com.proyectoweb.entity.OrdenCompra;
import com.proyectoweb.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    public List<OrdenCompra> findAll() {
        return ordenCompraRepository.findAll();
    }

    public Optional<OrdenCompra> findById(Long id) {
        return ordenCompraRepository.findById(id);
    }

    public OrdenCompra save(OrdenCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }

    public void deleteById(Long id) {
        ordenCompraRepository.deleteById(id);
    }

    // Otros métodos de servicio personalizados si es necesario
}
