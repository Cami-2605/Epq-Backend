package com.epq.epq_backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "periodos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}