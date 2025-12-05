package com.epq.epq_backend.service;

import com.epq.epq_backend.dto.*;

public interface AuthService {
    AuthResponseDto registrar(RegistroUsuarioDto dto);
    AuthResponseDto login(LoginDto dto);
}