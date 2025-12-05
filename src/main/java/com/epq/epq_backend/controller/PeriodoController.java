package com.epq.epq_backend.controller;

import com.epq.epq_backend.dto.PeriodoDto;
import com.epq.epq_backend.service.PeriodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periodos")
public class PeriodoController {

    private final PeriodoService periodoService;

    public PeriodoController(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }

    @GetMapping
    public List<PeriodoDto> listar() {
        return periodoService.listar();
    }

    @GetMapping("/{id}")
    public PeriodoDto obtener(@PathVariable Long id) {
        return periodoService.buscarPorId(id);
    }
}