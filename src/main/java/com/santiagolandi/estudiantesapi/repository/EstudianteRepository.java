package com.santiagolandi.estudiantesapi.repository;

import com.santiagolandi.estudiantesapi.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
