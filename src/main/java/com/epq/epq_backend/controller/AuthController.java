package com.epq.epq_backend.controller;

import com.epq.epq_backend.dto.*;
import com.epq.epq_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/registro")
    public AuthResponseDto registrar(@RequestBody RegistroUsuarioDto dto) {
        return authService.registrar(dto);
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody LoginDto dto) {
        return authService.login(dto);
    }
}