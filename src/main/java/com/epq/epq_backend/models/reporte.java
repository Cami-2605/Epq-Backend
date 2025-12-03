package com.epq.epq_backend.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "reportes")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Municipio seleccionado
    @ManyToOne
    @JoinColumn(name = "municipio_id")
    private municipio municipio;

    // Periodo seleccionado
    @ManyToOne
    @JoinColumn(name = "periodo_id")
    private periodo periodo;

    private LocalDate fechaDesde;

    private LocalDate fechaHasta;
}