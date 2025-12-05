package com.epq.epq_backend.repositories;

import com.epq.epq_backend.models.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Long> {

    @Query("""
        SELECT r FROM Reporte r
        WHERE (:municipioId IS NULL OR r.municipio.id = :municipioId)
          AND (:periodoId IS NULL OR r.periodo.id = :periodoId)
          AND (:fechaDesde IS NULL OR r.fechaDesde >= TO_DATE(:fechaDesde, 'YYYY-MM-DD'))
          AND (:fechaHasta IS NULL OR r.fechaHasta <= TO_DATE(:fechaHasta, 'YYYY-MM-DD'))
        """)
    List<Reporte> filtrar(Long municipioId, Long periodoId, String fechaDesde, String fechaHasta);
}