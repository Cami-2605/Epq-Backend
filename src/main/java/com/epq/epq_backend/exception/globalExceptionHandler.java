package com.epq.epq_backend.exception;

import com.epq.epq_backend.dto.errorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.stream.Collectors;

@ControllerAdvice
public class globalExceptionHandler {

  private ResponseEntity<errorResponse> buildResponse(HttpStatus status, String message, String path) {
    errorResponse err = errorResponse.builder()
            .timestamp(Instant.now())
            .status(status.value())
            .error(status.getReasonPhrase())
            .message(message)
            .path(path)
            .build();
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(resourceNotFoundException.class)
  public ResponseEntity<errorResponse> handleNotFound(resourceNotFoundException ex, WebRequest request) {
    return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request.getDescription(false));
  }

  @ExceptionHandler(badRequestException.class)
  public ResponseEntity<errorResponse> handleBadRequest(badRequestException ex, WebRequest request) {
    return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
  }

  @ExceptionHandler(conflictException.class)
  public ResponseEntity<errorResponse> handleConflict(conflictException ex, WebRequest request) {
    return buildResponse(HttpStatus.CONFLICT, ex.getMessage(), request.getDescription(false));
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<errorResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
    String msg = String.format("Parámetro '%s' inválido: %s", ex.getName(), ex.getMessage());
    return buildResponse(HttpStatus.BAD_REQUEST, msg, request.getDescription(false));
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<errorResponse> handleNotReadable(HttpMessageNotReadableException ex, WebRequest request) {
    return buildResponse(HttpStatus.BAD_REQUEST,
            "Request JSON inválido o mal formado",
            request.getDescription(false));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<errorResponse> handleValidation(MethodArgumentNotValidException ex, WebRequest request) {
    String message = ex.getBindingResult().getFieldErrors()
            .stream()
            .map(FieldError::getDefaultMessage)
            .collect(Collectors.joining("; "));
    return buildResponse(HttpStatus.BAD_REQUEST, message, request.getDescription(false));
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<errorResponse> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
    String message = ex.getConstraintViolations()
            .stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.joining("; "));
    return buildResponse(HttpStatus.BAD_REQUEST, message, request.getDescription(false));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<errorResponse> handleAll(Exception ex, WebRequest request) {
    ex.printStackTrace();
    return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR,
            "Error interno del servidor",
            request.getDescription(false));
  }
}