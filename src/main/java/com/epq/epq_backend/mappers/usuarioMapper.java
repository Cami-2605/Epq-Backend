package com.epq.epq_backend.mappers;

import com.epq.epq_backend.dto.registroUsuarioDto;
import com.epq.epq_backend.dto.usuarioDto;
import com.epq.epq_backend.models.usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface usuarioMapper {
    usuarioDto toDto(usuario entity);

    usuario toEntity(usuarioDto dto);

    usuario toEntity(registroUsuarioDto dto);
}