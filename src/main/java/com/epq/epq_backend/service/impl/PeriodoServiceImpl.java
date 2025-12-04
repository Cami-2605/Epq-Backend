package com.epq.epq_backend.service.impl;

import com.epq.epq_backend.dto.PeriodoDto;
import com.epq.epq_backend.repository.PeriodoRepository;
import com.epq.epq_backend.service.PeriodoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PeriodoServiceImpl implements PeriodoService {
    private final PeriodoRepository periodoRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PeriodoDto> listar() {
        return periodoRepository.findAll()
                .stream()
                .map(p -> modelMapper.map(p, PeriodoDto.class))
                .toList();
    }
}