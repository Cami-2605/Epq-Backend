package com.epq.epq_backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PERIODO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERIODO")
    private Long id;

    @Column(nullable = false, length = 20)
    private String descripcion;
}
