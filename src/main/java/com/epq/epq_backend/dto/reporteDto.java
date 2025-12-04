package com.epq.epq_backend.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class reporteDto {
    private Long id;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
}