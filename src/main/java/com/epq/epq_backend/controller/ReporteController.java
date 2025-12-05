package com.epq.epq_backend.controller;

import com.epq.epq_backend.dto.ReporteDto;
import com.epq.epq_backend.service.ReporteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @PostMapping
    public ReporteDto guardar(@RequestBody ReporteDto dto) {
        return reporteService.guardar(dto);
    }

    @GetMapping
    public List<ReporteDto> listar() {
        return reporteService.listar();
    }

    @GetMapping("/{id}")
    public ReporteDto obtenerPorId(@PathVariable Long id) {
        return reporteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ReporteDto actualizar(@PathVariable Long id, @RequestBody ReporteDto dto) {
        return reporteService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reporteService.eliminar(id);
    }

    @GetMapping("/filtrar")
    public List<ReporteDto> filtrar(
            @RequestParam Long municipioId,
            @RequestParam Long periodoId,
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin
    ) {
        return reporteService.filtrar(municipioId, periodoId, fechaInicio, fechaFin);
    }
}