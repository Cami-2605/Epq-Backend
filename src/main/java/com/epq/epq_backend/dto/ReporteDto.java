package com.epq.epq_backend.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReporteDto {
    Long id;
    LocalDate fechaDesde;
    LocalDate fechaHasta;
}