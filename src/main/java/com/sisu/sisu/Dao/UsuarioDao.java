package com.sisu.sisu.Dao;

import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Integer>{
    
}
