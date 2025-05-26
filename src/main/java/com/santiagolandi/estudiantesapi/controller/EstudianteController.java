package com.santiagolandi.estudiantesapi.controller;

import com.santiagolandi.estudiantesapi.dto.EstudianteDTO;
import com.santiagolandi.estudiantesapi.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/")
    public ResponseEntity<?>obtenerEstudiantes() {
        List<EstudianteDTO>estudiantes = estudianteService.obtenerTodos();
        if (estudiantes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>obtenerEstudiantePorId(@PathVariable Long id) {
        EstudianteDTO buscado = estudianteService.obtenerEstudiante(id);
        return ResponseEntity.ok(buscado);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarEstudiante(@Valid @RequestBody EstudianteDTO estudiante) {
        estudianteService.crearEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>actualizarEstudiante(@Valid @RequestBody EstudianteDTO estudiante, @PathVariable Long id) {
        estudianteService.actualizarEstudiante(id, estudiante);
        return ResponseEntity.ok(estudiante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.ok().build();
    }


}
