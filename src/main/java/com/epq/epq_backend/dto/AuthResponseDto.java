package com.epq.epq_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AuthResponseDto {
    private String mensaje;
    private Long idUsuario;
    private String usuario;
}