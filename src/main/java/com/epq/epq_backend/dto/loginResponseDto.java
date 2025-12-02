package com.epq.epq_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class loginResponseDto {
    private Long id;
    private String usuario;
    private String nombres;
    private String apellidos;
    private String token; // opcional, luego lo implementamos si quieres JWT
}