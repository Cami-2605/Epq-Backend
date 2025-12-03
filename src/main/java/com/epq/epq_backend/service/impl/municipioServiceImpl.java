package com.epq.epq_backend.service.impl;

import com.epq.epq_backend.dto.municipioDto;
import com.epq.epq_backend.repository.municipioRepository;
import com.epq.epq_backend.service.municipioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class municipioServiceImpl implements municipioService {

    private final municipioRepository municipioRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<municipioDto> listar() {
        return municipioRepository.findAll()
                .stream()
                .map(m -> modelMapper.map(m, municipioDto.class))
                .toList();
    }
}