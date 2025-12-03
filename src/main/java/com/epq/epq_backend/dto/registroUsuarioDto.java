package com.epq.epq_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class registroUsuarioDto {
    private String nombres;
    private String apellidos;
    private String documento;
    private String telefono;
    private String correo;
    private String usuario;
    private String contrasena;
}