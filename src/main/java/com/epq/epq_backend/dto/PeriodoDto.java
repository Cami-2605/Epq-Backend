package com.epq.epq_backend.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeriodoDto {
    Long id;
    LocalDate fechaInicio;
    LocalDate fechaFin;
}