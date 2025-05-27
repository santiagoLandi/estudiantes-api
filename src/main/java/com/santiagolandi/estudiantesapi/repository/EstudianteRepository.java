package com.santiagolandi.estudiantesapi.repository;

import com.santiagolandi.estudiantesapi.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {


    List<Estudiante> findByCiudad(String ciudad);

    List<Estudiante> findByNombre(String nombre);

    Estudiante findByEmail(String mail);
}
