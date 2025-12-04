package com.epq.epq_backend.service.impl;

import com.epq.epq_backend.dto.ReporteDto;
import com.epq.epq_backend.models.Reporte;
import com.epq.epq_backend.repository.ReporteRepository;
import com.epq.epq_backend.service.ReporteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements ReporteService {
    private final ReporteRepository reporteRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ReporteDto> listar() {
        return reporteRepository.findAll()
                .stream()
                .map(r -> modelMapper.map(r, ReporteDto.class))
                .toList();
    }

    @Override
    public List<ReporteDto> filtrar(Long municipioId, Long periodoId, String fechaInicio, String fechaFin) {

        LocalDate inicio = LocalDate.parse(fechaInicio);
        LocalDate fin = LocalDate.parse(fechaFin);

        List<Reporte> lista = reporteRepository
                .findByMunicipioIdAndPeriodoIdAndFechaBetween(
                        municipioId, periodoId, inicio, fin
                );

        return lista.stream()
                .map(r -> modelMapper.map(r, ReporteDto.class))
                .toList();
    }
}