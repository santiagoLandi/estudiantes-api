package com.santiagolandi.estudiantesapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationException(MethodArgumentNotValidException ex) {
        String detalle = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                .orElse("Datos inválidos");
        ErrorMessage error = new ErrorMessage("Validación fallida", detalle);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Para ciudad sin estudiantes
    @ExceptionHandler(CiudadSinEstudiantesException.class)
    public ResponseEntity<ErrorMessage> handleCiudadSinEstudiantes(CiudadSinEstudiantesException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("Ciudad no encontrada", ex.getMessage()));
    }

    // Para cuando el nombre indicado no trae estudiantes
    @ExceptionHandler(NombreSinEstudiantesException.class)
    public ResponseEntity<ErrorMessage> handleNombreSinEstudiantes(NombreSinEstudiantesException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("Nombre no encontrado", ex.getMessage()));
    }

    // 👇 Manejo específico para email sin estudiante
    @ExceptionHandler(EmailSinEstudianteException.class)
    public ResponseEntity<ErrorMessage> handleEmailSinEstudiante(EmailSinEstudianteException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("Email no encontrado", ex.getMessage()));
    }

    // excepcion generica
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException ex) {
        ErrorMessage error = new ErrorMessage("Error interno", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}



record ErrorMessage(String mensaje, String detalle) {}
