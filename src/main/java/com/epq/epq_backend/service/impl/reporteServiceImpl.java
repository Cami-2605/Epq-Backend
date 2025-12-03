package com.epq.epq_backend.service.impl;

import com.epq.epq_backend.dto.reporteDto;
import com.epq.epq_backend.models.reporte;
import com.epq.epq_backend.repository.reporteRepository;
import com.epq.epq_backend.service.reporteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class reporteServiceImpl implements reporteService {

    private final reporteRepository reporteRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<reporteDto> listar() {
        return reporteRepository.findAll()
                .stream()
                .map(r -> modelMapper.map(r, reporteDto.class))
                .toList();
    }

    @Override
    public List<reporteDto> filtrar(Long municipioId, Long periodoId, String fechaInicio, String fechaFin) {

        LocalDate inicio = LocalDate.parse(fechaInicio);
        LocalDate fin = LocalDate.parse(fechaFin);

        List<reporte> lista = reporteRepository
                .findByMunicipioIdAndPeriodoIdAndFechaBetween(
                        municipioId, periodoId, inicio, fin
                );

        return lista.stream()
                .map(r -> modelMapper.map(r, reporteDto.class))
                .toList();
    }
}