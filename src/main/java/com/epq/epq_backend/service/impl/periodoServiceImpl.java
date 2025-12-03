package com.epq.epq_backend.service.impl;

import com.epq.epq_backend.dto.periodoDto;
import com.epq.epq_backend.repository.periodoRepository;
import com.epq.epq_backend.service.periodoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class periodoServiceImpl implements periodoService {

    private final periodoRepository periodoRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<periodoDto> listar() {
        return periodoRepository.findAll()
                .stream()
                .map(p -> modelMapper.map(p, periodoDto.class))
                .toList();
    }
}