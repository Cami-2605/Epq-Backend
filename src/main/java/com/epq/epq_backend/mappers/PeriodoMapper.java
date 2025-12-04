package com.epq.epq_backend.mappers;

import com.epq.epq_backend.dto.PeriodoDto;
import com.epq.epq_backend.models.Periodo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeriodoMapper {
    PeriodoDto toDto(Periodo entity);
    Periodo toEntity(PeriodoDto dto);
}