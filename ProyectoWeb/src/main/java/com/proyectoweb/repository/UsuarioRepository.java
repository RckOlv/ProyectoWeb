// UsuarioRepository.java
package com.proyectoweb.repository;

import com.proyectoweb.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombreUsuario(String nombre_usuario);
}

