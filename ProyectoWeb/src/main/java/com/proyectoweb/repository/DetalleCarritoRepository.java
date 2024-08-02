package com.proyectoweb.repository;

import com.proyectoweb.entity.DetalleCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCarritoRepository extends JpaRepository<DetalleCarrito, Long> {
    // Aquí puedes añadir métodos personalizados si es necesario
}
