package com.santiagolandi.estudiantesapi.service;


import com.santiagolandi.estudiantesapi.dto.EstudianteDTO;
import com.santiagolandi.estudiantesapi.entity.Estudiante;
import com.santiagolandi.estudiantesapi.exception.EstudianteNoEncontradoException;
import com.santiagolandi.estudiantesapi.mapper.EstudianteMapper;
import com.santiagolandi.estudiantesapi.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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
                .orElseThrow(()-> new EstudianteNoEncontradoException(id));
        return estudianteMapper.toEstudianteDTO(estudiante);
    }

    @Transactional
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO){
        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre(estudianteDTO.getNombre());
        nuevoEstudiante.setApellido(estudianteDTO.getApellido());
        nuevoEstudiante.setDni(estudianteDTO.getDni());
        nuevoEstudiante.setEmail(estudianteDTO.getEmail());
        nuevoEstudiante.setCiudad(estudianteDTO.getCiudad());
        estudianteRepository.save(nuevoEstudiante);
        return estudianteMapper.toEstudianteDTO(nuevoEstudiante);
    }

    @Transactional
    public EstudianteDTO actualizarEstudiante(Long id,EstudianteDTO estudianteDTO){
        Estudiante buscado = estudianteRepository.findById(id).orElseThrow(()-> new EstudianteNoEncontradoException(id));
        buscado.setNombre(estudianteDTO.getNombre());
        buscado.setApellido(estudianteDTO.getApellido());
        buscado.setDni(estudianteDTO.getDni());
        buscado.setEmail(estudianteDTO.getEmail());
        buscado.setCiudad(estudianteDTO.getCiudad());
        estudianteRepository.save(buscado);
        return estudianteMapper.toEstudianteDTO(buscado);
    }

    @Transactional
    public void eliminarEstudiante(Long id){
        Estudiante buscado = estudianteRepository.findById(id).orElseThrow(()-> new EstudianteNoEncontradoException(id));
        estudianteRepository.delete(buscado);
    }
}
