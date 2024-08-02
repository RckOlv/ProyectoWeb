package com.proyectoweb.repository;

import com.proyectoweb.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Aquí puedes añadir métodos personalizados si es necesario
}
