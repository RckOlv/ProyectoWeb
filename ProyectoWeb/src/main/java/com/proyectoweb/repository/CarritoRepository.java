package com.proyectoweb.repository;

import com.proyectoweb.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    // Aquí puedes añadir métodos personalizados si es necesario
}
