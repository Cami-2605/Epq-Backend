package com.epq.epq_backend.mappers;

import com.epq.epq_backend.dto.reporteDto;
import com.epq.epq_backend.models.reporte;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface reporteMapper {
    reporteDto toDto(reporte entity);

    reporte toEntity(reporteDto dto);
}