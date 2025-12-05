package com.epq.epq_backend.service;

import com.epq.epq_backend.dto.MunicipioDto;
import java.util.List;

public interface MunicipioService {
    List<MunicipioDto> listar();
    MunicipioDto buscarPorId(Long id);
}