package com.epq.epq_backend.service;

import com.epq.epq_backend.dto.ReporteDto;

import java.util.List;

public interface ReporteService {
    List<ReporteDto> listar();
    List<ReporteDto> filtrar(Long municipioId, Long periodoId, String fechaInicio, String fechaFin);
}