package com.epq.epq_backend.controller;

import com.epq.epq_backend.dto.*;
import com.epq.epq_backend.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody LoginDto dto) {
        return usuarioService.login(dto);
    }

    @PostMapping("/registro")
    public UsuarioDto registrar(@RequestBody RegistroUsuarioDto dto) {
        return usuarioService.registrar(dto);
    }
}