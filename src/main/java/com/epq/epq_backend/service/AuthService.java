package com.epq.epq_backend.service;

import com.epq.epq_backend.dto.*;
import com.epq.epq_backend.exception.BadRequestException;
import com.epq.epq_backend.exception.ConflictException;
import com.epq.epq_backend.exception.NotFoundException;
import com.epq.epq_backend.mappers.UsuarioMapper;
import com.epq.epq_backend.models.Usuario;
import com.epq.epq_backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public AuthResponseDto registrar(RegistroUsuarioDto dto) {

        if (usuarioRepository.existsByUsuario(dto.getUsuario())) {
            throw new ConflictException("El nombre de usuario ya está registrado.");
        }

        Usuario nuevo = usuarioMapper.toEntity(dto);
        usuarioRepository.save(nuevo);

        return AuthResponseDto.builder()
                .mensaje("Registro exitoso.")
                .idUsuario(nuevo.getId())
                .usuario(nuevo.getUsuario())
                .build();
    }

    public AuthResponseDto login(LoginDto dto) {

        Usuario encontrado = usuarioRepository.findByUsuario(dto.getUsuario())
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado."));

        if (!encontrado.getPassword().equals(dto.getPassword())) {
            throw new BadRequestException("Contraseña incorrecta.");
        }

        return AuthResponseDto.builder()
                .mensaje("Login exitoso.")
                .idUsuario(encontrado.getId())
                .usuario(encontrado.getUsuario())
                .build();
    }
}