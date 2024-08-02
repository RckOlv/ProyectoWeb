package com.proyectoweb.repository;

import com.proyectoweb.entity.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {
    // Aquí puedes añadir métodos personalizados si es necesario
}
