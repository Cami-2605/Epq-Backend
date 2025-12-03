package com.epq.epq_backend.repository;

import com.epq.epq_backend.models.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface usuarioRepository extends JpaRepository<usuario, Long> {

    Optional<usuario> findByUsuario(String usuario);

    boolean existsByUsuario(String usuario);

    boolean existsByCorreo(String correo);
}