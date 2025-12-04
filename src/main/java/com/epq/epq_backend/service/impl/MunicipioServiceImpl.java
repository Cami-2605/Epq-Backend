package com.epq.epq_backend.service.impl;

import com.epq.epq_backend.dto.MunicipioDto;
import com.epq.epq_backend.repository.MunicipioRepository;
import com.epq.epq_backend.service.MunicipioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MunicipioServiceImpl implements MunicipioService {
    private final MunicipioRepository municipioRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<MunicipioDto> listar() {
        return municipioRepository.findAll()
                .stream()
                .map(m -> modelMapper.map(m, MunicipioDto.class))
                .toList();
    }
}