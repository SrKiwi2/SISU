package com.sisu.sisu.Dao;

import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long> {
    
}
