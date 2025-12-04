package com.epq.epq_backend.controller;

import com.epq.epq_backend.dto.PeriodoDto;
import com.epq.epq_backend.service.PeriodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periodos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PeriodoController {
    private final PeriodoService periodoService;

    @GetMapping
    public ResponseEntity<List<PeriodoDto>> listar() {
        return ResponseEntity.ok(periodoService.listar());
    }
}