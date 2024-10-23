package com.proadmin.icfes.Repositories;

import com.proadmin.icfes.Entities.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteRepository extends MongoRepository<Estudiante, Long> {

    Optional<Estudiante> findByNumeroRegistro(String numeroRegistro);
}