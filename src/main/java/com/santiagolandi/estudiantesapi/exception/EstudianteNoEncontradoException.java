package com.santiagolandi.estudiantesapi.exception;

public class EstudianteNoEncontradoException extends RuntimeException {
    public EstudianteNoEncontradoException(Long id) {
        super("Estudiante no encontrado con id " + id);
    }
}
