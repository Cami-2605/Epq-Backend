package com.epq.epq_backend.controller;

import com.epq.epq_backend.dto.loginDto;
import com.epq.epq_backend.dto.usuarioDto;
import com.epq.epq_backend.service.usuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class authController {

    private final usuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<usuarioDto> registrarUsuario(@RequestBody RegistroUsuarioDto dto) {
        return ResponseEntity.ok(usuarioService.registrar(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<usuarioDto> login(@RequestBody loginDto dto) {
        return ResponseEntity.ok(usuarioService.login(dto));
    }
}