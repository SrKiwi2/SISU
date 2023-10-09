package com.sisu.sisu.Dao;

import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.Usuarios;

public interface UsuarioDao extends CrudRepository<Usuarios, Integer>{
    
}
