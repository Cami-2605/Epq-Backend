package com.epq.epq_backend.mappers;

import com.epq.epq_backend.dto.RegistroUsuarioDto;
import com.epq.epq_backend.dto.UsuarioDto;
import com.epq.epq_backend.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioDto toDto(Usuario entity);
    Usuario toEntity(UsuarioDto dto);
    Usuario toEntity(RegistroUsuarioDto dto);
}