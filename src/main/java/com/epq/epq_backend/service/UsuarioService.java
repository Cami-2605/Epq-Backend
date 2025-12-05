package com.epq.epq_backend.service;

import com.epq.epq_backend.dto.*;

import java.util.List;

public interface UsuarioService {
    UsuarioDto obtenerPorId(Long id);
    List<UsuarioDto> listar();
    UsuarioDto actualizar(Long id, UsuarioDto dto);
    void eliminar(Long id);

    UsuarioDto registrar(RegistroUsuarioDto dto);
    AuthResponseDto login(LoginDto dto);
}