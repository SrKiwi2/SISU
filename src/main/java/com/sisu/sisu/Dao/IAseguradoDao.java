package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.Asegurado;

public interface IAseguradoDao extends CrudRepository<Asegurado, Integer> {
    @Query(value = "SELECT * FROM asegurado WHERE asegurado.id_persona = ?1 AND asegurado.estado = 'A'", nativeQuery = true)
    Asegurado findAseguradoByPersonaId(Integer personaId);

    Asegurado findByPersonaCi(String personaCod);

    @Query(value = "SELECT * FROM asegurado WHERE asegurado.id_persona = ?1 AND asegurado.estado ='A' AND asegurado.id_asegurado = ?2", nativeQuery = true)
    Asegurado findAseguradoByCodigoAsegurado(Integer id_persona, Integer id_asegurado);
}
