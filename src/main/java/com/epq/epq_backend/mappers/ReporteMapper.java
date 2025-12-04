package com.epq.epq_backend.mappers;

import com.epq.epq_backend.dto.ReporteDto;
import com.epq.epq_backend.models.Reporte;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReporteMapper {
    ReporteDto toDto(Reporte entity);
    Reporte toEntity(ReporteDto dto);
}