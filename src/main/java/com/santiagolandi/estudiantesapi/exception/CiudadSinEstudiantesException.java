package com.santiagolandi.estudiantesapi.exception;

public class CiudadSinEstudiantesException extends RuntimeException {
    public CiudadSinEstudiantesException(String ciudad) {
        super("No existen estudiantes de la ciudad de :" +ciudad);
    }
}
