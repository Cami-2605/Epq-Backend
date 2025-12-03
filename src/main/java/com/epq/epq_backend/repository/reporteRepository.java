package com.epq.epq_backend.repository;

import com.epq.epq_backend.models.reporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface reporteRepository extends JpaRepository<reporte, Long> {

    List<reporte> findByMunicipioIdAndPeriodoIdAndFechaBetween(
            Long municipioId,
            Long periodoId,
            LocalDate fechaInicio,
            LocalDate fechaFin
    );
}