package com.epq.epq_backend.exception;

import com.epq.epq_backend.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice

public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse notFound(NotFoundException ex, WebRequest req) {
    return ErrorResponse.builder()
            .status(404)
            .error("Not Found")
            .message(ex.getMessage())
            .path(req.getDescription(false))
            .build();
  }

  @ExceptionHandler(ConflictException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ErrorResponse conflict(ConflictException ex, WebRequest req) {
    return ErrorResponse.builder()
            .status(409)
            .error("Conflict")
            .message(ex.getMessage())
            .path(req.getDescription(false))
            .build();
  }

  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse badRequest(BadRequestException ex, WebRequest req) {
    return ErrorResponse.builder()
            .status(400)
            .error("Bad Request")
            .message(ex.getMessage())
            .path(req.getDescription(false))
            .build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse internal(Exception ex, WebRequest req) {
    ex.printStackTrace();
    return ErrorResponse.builder()
            .status(500)
            .error("Internal Server Error")
            .message(ex.getMessage())
            .path(req.getDescription(false))
            .build();
  }
}