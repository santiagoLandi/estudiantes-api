package com.santiagolandi.estudiantesapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public class EstudianteDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "El dni es obligatorio")
    private Long dni;

    @Email(message = "Debe ser un mail valido")
    @NotBlank(message = "El mail es obligatorio")
    private String email;

    @NotBlank(message = "La ciudad es obligatorio")
    private String ciudad;

    public EstudianteDTO() {}

    public EstudianteDTO(String nombre, String apellido, Long dni, String email, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Long getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public @NotBlank(message = "La ciudad es obligatorio") String getCiudad() {
        return ciudad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
