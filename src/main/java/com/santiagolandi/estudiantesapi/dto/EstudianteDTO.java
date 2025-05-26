package com.santiagolandi.estudiantesapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteDTO {
    private String nombre;
    private String apellido;
    private Long dni;
    private String email;
    private String ciudad;
}
