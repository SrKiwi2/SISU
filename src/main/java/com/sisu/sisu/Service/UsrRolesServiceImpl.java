package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.UsrRolesDao;
import com.sisu.sisu.entitys.UsrRoles;

@Service
public class UsrRolesServiceImpl implements UsrRolesService {
	
	@Autowired
	UsrRolesDao usrRolesDao;

	@Override
	public List<UsrRoles> findAll() {
		        return (List<UsrRoles>) usrRolesDao.findAll();

	}

	@Override
	public void registrarUsrRoles(UsrRoles usrRoles) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'registrarUsrRoles'");
	}
	

	
	// @Override
	// public List<UsrRoles> listarRoles() {
	// 	// TODO Auto-generated method stub
	// 	return usrRolesDao.listarRoles() ;
	// }

	// @Override
	// public void registrarUsrRoles(UsrRoles usrRoles) {
	// 	usrRolesDao.save(usrRoles);		
	// }
	
	
	

}
