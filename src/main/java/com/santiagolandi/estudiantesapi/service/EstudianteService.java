package com.santiagolandi.estudiantesapi.service;


import com.santiagolandi.estudiantesapi.dto.EstudianteDTO;
import com.santiagolandi.estudiantesapi.entity.Estudiante;
import com.santiagolandi.estudiantesapi.exception.CiudadSinEstudiantesException;
import com.santiagolandi.estudiantesapi.exception.EmailSinEstudianteException;
import com.santiagolandi.estudiantesapi.exception.EstudianteNoEncontradoException;
import com.santiagolandi.estudiantesapi.exception.NombreSinEstudiantesException;
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
                .orElseThrow(()-> new EstudianteNoEncontradoException(id));
        return estudianteMapper.toEstudianteDTO(estudiante);
    }

    @Transactional
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO){
        Estudiante nuevoEstudiante = new Estudiante();
        return mapearAestudianteDTO(estudianteDTO, nuevoEstudiante);
    }

    @Transactional
    public EstudianteDTO actualizarEstudiante(Long id,EstudianteDTO estudianteDTO){
        Estudiante buscado = estudianteRepository.findById(id).orElseThrow(()-> new EstudianteNoEncontradoException(id));
        return mapearAestudianteDTO(estudianteDTO, buscado);
    }

    private EstudianteDTO mapearAestudianteDTO(EstudianteDTO estudianteDTO, Estudiante buscado) {
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

    @Transactional(readOnly = true)
    public List<EstudianteDTO> obtenerEstudiantesPorCiudad(String ciudad){
        List<Estudiante>filtrados = estudianteRepository.findByCiudad(ciudad);
        if(filtrados.isEmpty()){
            throw  new CiudadSinEstudiantesException(ciudad);
        }
        return filtrados.stream().map(estudianteMapper::toEstudianteDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EstudianteDTO> obtenerEstudiantesPorNombre(String nombre){
        List<Estudiante>buscados = estudianteRepository.findByNombre(nombre);
        if(buscados.isEmpty()){
            throw new NombreSinEstudiantesException(nombre);
        }
        return buscados.stream().map(estudianteMapper::toEstudianteDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EstudianteDTO obtenerEstudiantePorEmail(String email){
        Estudiante buscado = estudianteRepository.findByEmail(email);
        if(buscado == null){
            throw new EmailSinEstudianteException(email);
        }
        return estudianteMapper.toEstudianteDTO(buscado);
    }
}
