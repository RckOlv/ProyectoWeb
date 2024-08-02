package com.proyectoweb.repository;

import com.proyectoweb.entity.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> {
    // Aquí puedes añadir métodos personalizados si es necesario
}
