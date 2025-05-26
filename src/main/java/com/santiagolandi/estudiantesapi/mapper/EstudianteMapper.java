package com.santiagolandi.estudiantesapi.mapper;

import com.santiagolandi.estudiantesapi.dto.EstudianteDTO;
import com.santiagolandi.estudiantesapi.entity.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {
   public EstudianteDTO toEstudianteDTO(Estudiante estudiante) {
       return new EstudianteDTO(
               estudiante.getNombre(),
               estudiante.getApellido(),
               estudiante.getDni(),
               estudiante.getEmail(),
               estudiante.getCiudad()
       );
   }
}
