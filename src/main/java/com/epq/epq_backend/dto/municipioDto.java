package com.epq.epq_backend.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class municipioDto {
    private Long id;
    private String nombre;
}