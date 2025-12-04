package com.epq.epq_backend.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MunicipioDto {
    Long id;
    String nombre;
}