package com.epq.epq_backend.service;

import com.epq.epq_backend.dto.PeriodoDto;
import java.util.List;

public interface PeriodoService {
    List<PeriodoDto> listar();
    PeriodoDto buscarPorId(Long id);
}