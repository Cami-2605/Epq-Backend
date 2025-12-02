package com.epq.epq_backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MUNICIPIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MUNICIPIO")
    private Long id;

    @Column(nullable = false, length = 80)
    private String nombre;
}
