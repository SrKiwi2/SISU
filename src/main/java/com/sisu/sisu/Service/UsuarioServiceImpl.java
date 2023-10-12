package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.UsuarioDao;
import com.sisu.sisu.entitys.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> findAll() {
       
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public void save(Usuario usuario) {
        
        usuarioDao.save(usuario);
    }

    @Override
    public Usuario findOne(Long id) {
        
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        
        usuarioDao.deleteById(id);
    }
    
}
