package com.epq.epq_backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "municipios")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}