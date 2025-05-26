package com.santiagolandi.estudiantesapi.service;


import com.santiagolandi.estudiantesapi.dto.EstudianteDTO;
import com.santiagolandi.estudiantesapi.entity.Estudiante;
import com.santiagolandi.estudiantesapi.mapper.EstudianteMapper;
import com.santiagolandi.estudiantesapi.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository, EstudianteMapper estudianteMapper) {
        this.estudianteRepository = estudianteRepository;
        this.estudianteMapper = estudianteMapper;
    }

    @Transactional(readOnly = true)
    public List<EstudianteDTO> obtenerTodos(){
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudiantes.stream().map(estudianteMapper::toEstudianteDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EstudianteDTO obtenerEstudiante(Long id){
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Estudiante no encontrado con id: " + id) );
        return estudianteMapper.toEstudianteDTO(estudiante);
    }
}
