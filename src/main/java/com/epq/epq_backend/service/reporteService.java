package com.epq.epq_backend.service;

import com.epq.epq_backend.dto.reporteDto;

import java.util.List;

public interface reporteService {

    List<reporteDto> listar();

    List<reporteDto> filtrar(Long municipioId, Long periodoId, String fechaInicio, String fechaFin);
}