package com.epq.epq_backend.service;

import com.epq.epq_backend.dto.loginDto;
import com.epq.epq_backend.dto.registroUsuarioDto;
import com.epq.epq_backend.dto.usuarioDto;

import java.util.List;

public interface usuarioService {

    usuarioDto registrar(registroUsuarioDto dto);

    usuarioDto login(loginDto dto);

    List<usuarioDto> listar();

    usuarioDto obtenerPorId(Long id);
}