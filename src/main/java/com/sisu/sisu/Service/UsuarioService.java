package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.Usuario;

public interface UsuarioService {

    public List<Usuario> findAll(); //MOSTRAR TODOS LOS REGSITROS

    public void save(Usuario usuario);  //GUARDAR REGISTRO

    public Usuario findOne(Integer id);  // MOSTRAR UN REGSITRO

    public void delete(Integer id); // ELIMINAR REGISTRO
    
}
