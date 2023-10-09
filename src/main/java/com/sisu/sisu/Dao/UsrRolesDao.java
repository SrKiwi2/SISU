package com.sisu.sisu.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sisu.sisu.entitys.UsrRoles;

public interface UsrRolesDao extends JpaRepository<UsrRoles, Integer> {
	
	@Query("select d from UsrRoles d where  d.estado='A' ")
	List<UsrRoles>listarRoles();
	

}
