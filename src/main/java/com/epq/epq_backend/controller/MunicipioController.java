package com.epq.epq_backend.controller;

import com.epq.epq_backend.dto.MunicipioDto;
import com.epq.epq_backend.service.MunicipioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/municipios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MunicipioController {
    private final MunicipioService municipioService;

    @GetMapping
    public ResponseEntity<List<MunicipioDto>> listar() {
        return ResponseEntity.ok(municipioService.listar());
    }
}