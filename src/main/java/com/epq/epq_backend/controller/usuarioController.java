package com.epq.epq_backend.controller;

import com.epq.epq_backend.dto.usuarioDto;
import com.epq.epq_backend.service.usuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class usuarioController {

    private final usuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<usuarioDto>> listar() {
        return ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<usuarioDto> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerPorId(id));
    }
}