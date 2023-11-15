package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.UsrRolesDao;
import com.sisu.sisu.Dao.UsuarioDao;
import com.sisu.sisu.entitys.Roles;
import com.sisu.sisu.entitys.UsrRoles;
import com.sisu.sisu.entitys.Usuario;


@Service
public interface UsrRolesService {

	
	public List<UsrRoles> findAll(); // MOSTRAR TODOS LOS REGSITROS


	public UsrRoles findOne(Integer id);
	
	 void registrarUsrRoles(UsrRoles usrRoles);
	 public void save(UsrRoles usrRoles);


}
