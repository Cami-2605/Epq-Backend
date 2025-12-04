package com.epq.epq_backend.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class periodoDto {
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}