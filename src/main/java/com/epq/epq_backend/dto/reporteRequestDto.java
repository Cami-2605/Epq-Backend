package com.epq.epq_backend.dto;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class reporteRequestDto {
    private Long idMunicipio;
    private Long idPeriodo;
    private Date fechaInicio;
    private Date fechaFin;
}