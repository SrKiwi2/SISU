package com.sisu.sisu.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sisu.sisu.entitys.UsrRoles;
import com.sisu.sisu.entitys.Usuario;

public interface UsrRolesDao extends JpaRepository<UsrRoles, Integer> {
	
	@Query("SELECT u FROM Usuario u WHERE u.idUsuario = ?1")
    List<Usuario> buscarUsuarioPorId(Integer id);

}
