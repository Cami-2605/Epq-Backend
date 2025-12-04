package com.epq.epq_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDto {
    String nombres;
    String apellidos;
    String documento;
    String telefono;
    String correo;
    String usuario;
    String password;
}