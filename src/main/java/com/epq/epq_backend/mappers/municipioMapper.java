package com.epq.epq_backend.mappers;

import com.epq.epq_backend.dto.municipioDto;
import com.epq.epq_backend.models.municipio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface municipioMapper {
    municipioDto toDto(municipio entity);

    municipio toEntity(municipioDto dto);
}