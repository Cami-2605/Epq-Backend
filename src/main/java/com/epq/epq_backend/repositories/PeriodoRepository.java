package com.epq.epq_backend.repositories;

import com.epq.epq_backend.models.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoRepository extends JpaRepository<Periodo, Long> { }