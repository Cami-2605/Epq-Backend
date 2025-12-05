package com.epq.epq_backend.controller;

import com.epq.epq_backend.dto.MunicipioDto;
import com.epq.epq_backend.service.MunicipioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/municipios")
public class MunicipioController {

    private final MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping
    public List<MunicipioDto> listar() {
        return municipioService.listar();
    }

    @GetMapping("/{id}")
    public MunicipioDto obtener(@PathVariable Long id) {
        return municipioService.buscarPorId(id);
    }
}