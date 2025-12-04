package com.epq.epq_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class errorResponse {
    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}