package com.epq.epq_backend.service.impl;

import com.epq.epq_backend.dto.*;
import com.epq.epq_backend.exception.BadRequestException;
import com.epq.epq_backend.exception.NotFoundException;
import com.epq.epq_backend.mappers.UsuarioMapper;
import com.epq.epq_backend.models.Usuario;
import com.epq.epq_backend.repositories.UsuarioRepository;
import com.epq.epq_backend.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repo;
    private final UsuarioMapper mapper;

    public UsuarioServiceImpl(UsuarioRepository repo, UsuarioMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public UsuarioDto obtenerPorId(Long id) {
        Usuario u = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado."));
        return mapper.toDto(u);
    }

    @Override
    public List<UsuarioDto> listar() {
        return repo.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public UsuarioDto actualizar(Long id, UsuarioDto dto) {
        Usuario encontrado = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado."));

        encontrado.setNombres(dto.getNombres());
        encontrado.setApellidos(dto.getApellidos());
        encontrado.setDocumento(dto.getDocumento());
        encontrado.setTelefono(dto.getTelefono());
        encontrado.setCorreo(dto.getCorreo());
        encontrado.setUsuario(dto.getUsuario());

        return mapper.toDto(repo.save(encontrado));
    }

    @Override
    public void eliminar(Long id) {
        Usuario encontrado = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado."));
        repo.delete(encontrado);
    }

    @Override
    public UsuarioDto registrar(RegistroUsuarioDto dto) {

        if (repo.findByUsuario(dto.getUsuario()).isPresent()) {
            throw new BadRequestException("El usuario ya existe.");
        }

        Usuario nuevo = mapper.toEntity(dto);
        Usuario guardado = repo.save(nuevo);

        return mapper.toDto(guardado);
    }

    @Override
    public AuthResponseDto login(LoginDto dto) {
        Usuario encontrado = repo.findByUsuario(dto.getUsuario())
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado."));

        if (!encontrado.getPassword().equals(dto.getPassword())) {
            throw new BadRequestException("Contraseña incorrecta.");
        }

        return AuthResponseDto.builder()
                .mensaje("Login exitoso")
                .idUsuario(encontrado.getId())
                .usuario(encontrado.getUsuario()) // ← ahora coincide PERFECTO con el DTO
                .build();
    }
}