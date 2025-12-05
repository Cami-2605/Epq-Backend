package com.epq.epq_backend.mappers;

import com.epq.epq_backend.dto.RegistroUsuarioDto;
import com.epq.epq_backend.dto.UsuarioDto;
import com.epq.epq_backend.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDto toDto(Usuario entity);

    @Mapping(target = "password", source = "password")
    Usuario toEntity(RegistroUsuarioDto dto);

    Usuario toEntity(UsuarioDto dto);
}