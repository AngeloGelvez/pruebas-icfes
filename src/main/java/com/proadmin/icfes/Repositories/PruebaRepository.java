package com.proadmin.icfes.Repositories;

import com.proadmin.icfes.Entities.Prueba;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PruebaRepository extends MongoRepository<Prueba, String> {

    Optional<Prueba> findByNumeroRegistro(String numeroRegistro);
}