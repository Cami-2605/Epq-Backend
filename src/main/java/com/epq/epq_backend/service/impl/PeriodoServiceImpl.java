package com.epq.epq_backend.service.impl;

import com.epq.epq_backend.dto.PeriodoDto;
import com.epq.epq_backend.exception.NotFoundException;
import com.epq.epq_backend.mappers.PeriodoMapper;
import com.epq.epq_backend.models.Periodo;
import com.epq.epq_backend.repositories.PeriodoRepository;
import com.epq.epq_backend.service.PeriodoService;
import com.epq.epq_backend.util.TextoUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodoServiceImpl implements PeriodoService {

    private final PeriodoRepository periodoRepository;
    private final PeriodoMapper mapper;

    public PeriodoServiceImpl(PeriodoRepository periodoRepository, PeriodoMapper mapper) {
        this.periodoRepository = periodoRepository;
        this.mapper = mapper;
    }

    @Override
    public List<PeriodoDto> listar() {
        return periodoRepository.findAll()
                .stream()
                .map(periodo -> {
                    PeriodoDto dto = mapper.toDto(periodo);

                    if (dto.getNombre() != null) {
                        dto.setNombre(
                                TextoUtil.limpiarEspacios(
                                        TextoUtil.aMayusculas(dto.getNombre())
                                )
                        );
                    }
                    return dto;
                })
                .toList();
    }

    @Override
    public PeriodoDto buscarPorId(Long id) {
        Periodo encontrado = periodoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Periodo no encontrado: " + id));

        PeriodoDto dto = mapper.toDto(encontrado);

        if (dto.getNombre() != null) {
            dto.setNombre(
                    TextoUtil.limpiarEspacios(
                            TextoUtil.aMayusculas(dto.getNombre())
                    )
            );
        }
        return dto;
    }
}