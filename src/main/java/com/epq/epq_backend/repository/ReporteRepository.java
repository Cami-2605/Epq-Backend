package com.epq.epq_backend.repository;

import com.epq.epq_backend.models.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ReporteRepository extends JpaRepository<Reporte, Long> {
    List<Reporte> findByMunicipioIdAndPeriodoIdAndFechaBetween(
            Long municipioId,
            Long periodoId,
            LocalDate fechaInicio,
            LocalDate fechaFin
    );
}