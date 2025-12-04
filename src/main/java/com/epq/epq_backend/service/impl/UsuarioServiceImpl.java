package com.epq.epq_backend.service.impl;

import com.epq.epq_backend.dto.LoginDto;
import com.epq.epq_backend.dto.RegistroUsuarioDto;
import com.epq.epq_backend.dto.UsuarioDto;
import com.epq.epq_backend.models.Usuario;
import com.epq.epq_backend.repository.UsuarioRepository;
import com.epq.epq_backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto registrar(RegistroUsuarioDto dto) {
        Usuario usuario = modelMapper.map(dto, Usuario.class);

        usuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));

        usuarioRepository.save(usuario);
        return modelMapper.map(usuario, UsuarioDto.class);
    }

    @Override
    public UsuarioDto login(LoginDto dto) {
        Usuario usuario = usuarioRepository.findByUsuario(dto.getUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(dto.getContrasena(), usuario.getContrasena())) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        return modelMapper.map(usuario, UsuarioDto.class);
    }

    @Override
    public List<UsuarioDto> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(u -> modelMapper.map(u, UsuarioDto.class))
                .toList();
    }

    @Override
    public UsuarioDto obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return modelMapper.map(usuario, UsuarioDto.class);
    }
}