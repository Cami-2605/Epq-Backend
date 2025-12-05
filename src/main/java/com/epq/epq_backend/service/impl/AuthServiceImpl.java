package com.epq.epq_backend.service.impl;

import com.epq.epq_backend.dto.*;
import com.epq.epq_backend.exception.*;
import com.epq.epq_backend.mappers.UsuarioMapper;
import com.epq.epq_backend.models.Usuario;
import com.epq.epq_backend.repositories.UsuarioRepository;
import com.epq.epq_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponseDto registrar(RegistroUsuarioDto dto) {
        if (usuarioRepository.existsByUsuario(dto.getUsuario()))
            throw new ConflictException("Usuario ya registrado");

        Usuario u = usuarioMapper.toEntity(dto);
        u.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuarioRepository.save(u);

        return AuthResponseDto.builder()
                .mensaje("Registro exitoso")
                .idUsuario(u.getId())
                .usuario(u.getUsuario())
                .build();
    }

    @Override
    public AuthResponseDto login(LoginDto dto) {
        Usuario u = usuarioRepository.findByUsuario(dto.getUsuario())
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        if (!passwordEncoder.matches(dto.getPassword(), u.getPassword()))
            throw new BadRequestException("Credenciales incorrectas");

        return AuthResponseDto.builder()
                .mensaje("Login exitoso")
                .idUsuario(u.getId())
                .usuario(u.getUsuario())
                .build();
    }
}