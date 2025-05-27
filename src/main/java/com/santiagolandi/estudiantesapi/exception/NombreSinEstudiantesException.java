package com.santiagolandi.estudiantesapi.exception;

public class NombreSinEstudiantesException extends RuntimeException {
    public NombreSinEstudiantesException(String nombre) {
        super("No existen estudiantes con el nombre: " +nombre);
    }
}
