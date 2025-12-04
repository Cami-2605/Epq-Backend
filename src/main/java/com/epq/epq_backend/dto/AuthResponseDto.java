package com.epq.epq_backend.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {
    String mensaje;
    Long idUsuario;
    String usuario;
}