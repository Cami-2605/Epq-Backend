package com.epq.epq_backend.controller;

import com.epq.epq_backend.dto.municipioDto;
import com.epq.epq_backend.service.municipioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/municipios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class municipioController {

    private final municipioService municipioService;

    @GetMapping
    public ResponseEntity<List<municipioDto>> listar() {
        return ResponseEntity.ok(municipioService.listar());
    }
}