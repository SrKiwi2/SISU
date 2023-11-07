package com.sisu.sisu.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.idUsuario = ?1")
    Usuario buscarUsuarioPorId(Integer id);

}
