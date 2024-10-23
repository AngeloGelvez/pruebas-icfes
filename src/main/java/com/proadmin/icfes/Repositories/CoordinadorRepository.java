package com.proadmin.icfes.Repositories;

import com.proadmin.icfes.Entities.Coordinacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoordinadorRepository extends MongoRepository<Coordinacion, String> {

    Optional<Coordinacion> findByUsuario(String usuario);
}