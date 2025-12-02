package com.epq.epq_backend.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "REPORTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REPORTE")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_MUNICIPIO", nullable = false)
    private municipio municipio;

    @ManyToOne
    @JoinColumn(name = "ID_PERIODO", nullable = false)
    private periodo periodo;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaFin;
}

