package com.epq.epq_backend.controller;

import com.epq.epq_backend.dto.reporteDto;
import com.epq.epq_backend.service.reporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class reporteController {

    private final reporteService reporteService;

    @GetMapping
    public ResponseEntity<List<reporteDto>> listar() {
        return ResponseEntity.ok(reporteService.listar());
    }

    @GetMapping("/filtros")
    public ResponseEntity<List<reporteDto>> filtrar(
            @RequestParam Long municipioId,
            @RequestParam Long periodoId,
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin
    ) {
        return ResponseEntity.ok(
                reporteService.filtrar(municipioId, periodoId, fechaInicio, fechaFin)
        );
    }
}