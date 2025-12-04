package com.epq.epq_backend.service;

import com.epq.epq_backend.dto.LoginDto;
import com.epq.epq_backend.dto.RegistroUsuarioDto;
import com.epq.epq_backend.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    UsuarioDto registrar(RegistroUsuarioDto dto);
    UsuarioDto login(LoginDto dto);
    List<UsuarioDto> listar();
    UsuarioDto obtenerPorId(Long id);
}