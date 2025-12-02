package com.epq.epq_backend.dto;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class reporteResponseDto {
    private Long id;
    private String municipio;
    private String periodo;
    private Date fechaInicio;
    private Date fechaFin;
}