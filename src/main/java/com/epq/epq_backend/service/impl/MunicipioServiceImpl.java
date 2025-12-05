package com.epq.epq_backend.service.impl;

import com.epq.epq_backend.dto.MunicipioDto;
import com.epq.epq_backend.exception.NotFoundException;
import com.epq.epq_backend.mappers.MunicipioMapper;
import com.epq.epq_backend.models.Municipio;
import com.epq.epq_backend.repositories.MunicipioRepository;
import com.epq.epq_backend.service.MunicipioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioServiceImpl implements MunicipioService {

    private final MunicipioRepository municipioRepository;
    private final MunicipioMapper mapper;

    public MunicipioServiceImpl(MunicipioRepository municipioRepository, MunicipioMapper mapper) {
        this.municipioRepository = municipioRepository;
        this.mapper = mapper;
    }

    @Override
    public List<MunicipioDto> listar() {
        return municipioRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public MunicipioDto buscarPorId(Long id) {
        Municipio encontrado = municipioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Municipio no encontrado: " + id));

        return mapper.toDto(encontrado);
    }
}