package com.epq.epq_backend.dto;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class reporteDto {

    private Long municipioId;

    private Long periodoId;

    private LocalDate fechaDesde;

    private LocalDate fechaHasta;
}