package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sisu.sisu.entitys.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Integer> {

    @Query(value = "SELECT * FROM persona WHERE persona.ci = ?1", nativeQuery = true)
    public Persona findByCi(String ci);

    @Query("SELECT p FROM Persona p WHERE p.ci = :ci")
    Persona validarCI(@Param("ci") String ci);
}


