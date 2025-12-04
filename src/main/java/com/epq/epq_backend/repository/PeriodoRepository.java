package com.epq.epq_backend.repository;

import com.epq.epq_backend.models.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
}