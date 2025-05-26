package com.santiagolandi.estudiantesapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
