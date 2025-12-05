package com.epq.epq_backend.service;

import com.epq.epq_backend.dto.ReporteDto;

import java.util.List;

public interface ReporteService {
    ReporteDto guardar(ReporteDto dto);
    List<ReporteDto> listar();
    ReporteDto buscarPorId(Long id);
    ReporteDto actualizar(Long id, ReporteDto dto);
    void eliminar(Long id);
    List<ReporteDto> filtrar(Long municipioId, Long periodoId, String fechaDesde, String fechaHasta);
}