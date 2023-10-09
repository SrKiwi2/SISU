package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.UsuarioDao;
import com.sisu.sisu.entitys.Usuarios;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuarios> findAll() {
       
        return (List<Usuarios>) usuarioDao.findAll();
    }

    @Override
    public void save(Usuarios usuario) {
        
        usuarioDao.save(usuario);
    }

    @Override
    public Usuarios findOne(Integer id) {
        
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        
        usuarioDao.deleteById(id);
    }
    
}
