package com.santiagolandi.estudiantesapi.exception;

public class EmailSinEstudianteException extends RuntimeException {
    public EmailSinEstudianteException(String mail) {
        super("No se encuentra ningun estudiante con el mail: "+mail);
    }
}
