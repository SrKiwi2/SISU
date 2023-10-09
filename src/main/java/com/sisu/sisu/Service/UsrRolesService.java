package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.UsrRoles;

public interface UsrRolesService {
	List<UsrRoles>listarRoles();
	
	 void registrarUsrRoles(UsrRoles usrRoles);

}
