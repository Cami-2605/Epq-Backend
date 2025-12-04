package com.epq.epq_backend.mappers;

import com.epq.epq_backend.dto.periodoDto;
import com.epq.epq_backend.models.periodo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface periodoMapper {
    periodoDto toDto(periodo entity);

    periodo toEntity(periodoDto dto);
}