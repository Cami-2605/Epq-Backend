package com.epq.epq_backend.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class loginDto {
    private String usuario;
    private String contrasena;
}