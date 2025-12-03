package com.epq.epq_backend.service.impl;

import com.epq.epq_backend.dto.loginDto;
import com.epq.epq_backend.dto.registroUsuarioDto;
import com.epq.epq_backend.dto.usuarioDto;
import com.epq.epq_backend.models.usuario;
import com.epq.epq_backend.repository.usuarioRepository;
import com.epq.epq_backend.service.usuarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class usuarioServiceImpl implements usuarioService {

    private final usuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public usuarioDto registrar(registroUsuarioDto dto) {
        usuario usuario = modelMapper.map(dto, usuario.class);

        usuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));

        usuarioRepository.save(usuario);
        return modelMapper.map(usuario, usuarioDto.class);
    }

    @Override
    public usuarioDto login(loginDto dto) {
        usuario usuario = usuarioRepository.findByUsuario(dto.getUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(dto.getContrasena(), usuario.getContrasena())) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        return modelMapper.map(usuario, usuarioDto.class);
    }

    @Override
    public List<usuarioDto> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(u -> modelMapper.map(u, usuarioDto.class))
                .toList();
    }

    @Override
    public usuarioDto obtenerPorId(Long id) {
        usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return modelMapper.map(usuario,usuarioDto.class);
    }
}