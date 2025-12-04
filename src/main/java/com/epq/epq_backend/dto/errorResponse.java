package com.epq.epq_backend.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class errorResponse {

    private int status;        // 400, 404, 500...
    private String error;      // "Bad Request", "Not Found"...
    private String message;    // descripción del error
    private String path;       // endpoint donde ocurrió
}