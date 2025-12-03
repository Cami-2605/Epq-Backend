package com.epq.epq_backend.controller;

import com.epq.epq_backend.dto.periodoDto;
import com.epq.epq_backend.service.periodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periodos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class periodoController {

    private final periodoService periodoService;

    @GetMapping
    public ResponseEntity<List<periodoDto>> listar() {
        return ResponseEntity.ok(periodoService.listar());
    }
}