package com.epq.epq_backend.mappers;

import com.epq.epq_backend.dto.MunicipioDto;
import com.epq.epq_backend.models.Municipio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MunicipioMapper {
    MunicipioDto toDto(Municipio entity);
    Municipio toEntity(MunicipioDto dto);
}