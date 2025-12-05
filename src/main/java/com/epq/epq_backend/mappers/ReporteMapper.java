package com.epq.epq_backend.mappers;

import com.epq.epq_backend.dto.ReporteDto;
import com.epq.epq_backend.models.Reporte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReporteMapper {
    @Mapping(target = "municipio.id", source = "municipioId")
    @Mapping(target = "periodo.id", source = "periodoId")
    Reporte toEntity(ReporteDto dto);

    @Mapping(target = "municipioId", source = "municipio.id")
    @Mapping(target = "periodoId", source = "periodo.id")
    ReporteDto toDto(Reporte entity);
}