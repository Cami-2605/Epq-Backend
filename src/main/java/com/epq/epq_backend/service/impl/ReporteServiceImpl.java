package com.epq.epq_backend.service.impl;

import com.epq.epq_backend.dto.ReporteDto;
import com.epq.epq_backend.exception.BadRequestException;
import com.epq.epq_backend.exception.NotFoundException;
import com.epq.epq_backend.mappers.ReporteMapper;
import com.epq.epq_backend.models.Municipio;
import com.epq.epq_backend.models.Periodo;
import com.epq.epq_backend.models.Reporte;
import com.epq.epq_backend.repositories.MunicipioRepository;
import com.epq.epq_backend.repositories.PeriodoRepository;
import com.epq.epq_backend.repositories.ReporteRepository;
import com.epq.epq_backend.service.ReporteService;
import com.epq.epq_backend.util.FechaUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements ReporteService {

    private final ReporteRepository repo;
    private final MunicipioRepository municipioRepository;
    private final PeriodoRepository periodoRepository;
    private final ReporteMapper mapper;

    @Override
    public ReporteDto guardar(ReporteDto dto) {

        Municipio m = municipioRepository.findById(dto.getMunicipioId())
                .orElseThrow(() -> new NotFoundException("Municipio no encontrado"));

        Periodo p = periodoRepository.findById(dto.getPeriodoId())
                .orElseThrow(() -> new NotFoundException("Periodo no encontrado"));

        Reporte r = Reporte.builder()
                .municipio(m)
                .periodo(p)
                .fechaDesde(dto.getFechaDesde())
                .fechaHasta(dto.getFechaHasta())
                .observaciones(dto.getObservaciones())
                .build();

        r = repo.save(r);

        return mapper.toDto(r);
    }

    @Override
    public List<ReporteDto> listar() {
        return repo.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public ReporteDto buscarPorId(Long id) {
        Reporte r = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Reporte no encontrado"));
        return mapper.toDto(r);
    }

    @Override
    public ReporteDto actualizar(Long id, ReporteDto dto) {

        Reporte r = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Reporte no encontrado"));

        Municipio m = municipioRepository.findById(dto.getMunicipioId())
                .orElseThrow(() -> new NotFoundException("Municipio no encontrado"));

        Periodo p = periodoRepository.findById(dto.getPeriodoId())
                .orElseThrow(() -> new NotFoundException("Periodo no encontrado"));

        r.setMunicipio(m);
        r.setPeriodo(p);
        r.setFechaDesde(dto.getFechaDesde());
        r.setFechaHasta(dto.getFechaHasta());
        r.setObservaciones(dto.getObservaciones());

        repo.save(r);
        return mapper.toDto(r);
    }

    @Override
    public void eliminar(Long id) {
        Reporte r = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Reporte no encontrado"));
        repo.delete(r);
    }

    @Override
    public List<ReporteDto> filtrar(Long municipioId, Long periodoId, String fechaDesde, String fechaHasta) {

        if (!FechaUtil.esFechaValida(fechaDesde) || !FechaUtil.esFechaValida(fechaHasta)) {
            throw new BadRequestException("Formato de fecha inválido. Use yyyy-MM-dd.");
        }

        return repo.filtrar(
                        municipioId,
                        periodoId,
                        fechaDesde,
                        fechaHasta
                ).stream()
                .map(mapper::toDto)
                .toList();
    }
}