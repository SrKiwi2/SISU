package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.Usuarios;

public interface UsuarioService {

    public List<Usuarios> findAll(); //MOSTRAR TODOS LOS REGSITROS

    public void save(Usuarios usuario);  //GUARDAR REGISTRO

    public Usuarios findOne(Integer id);  // MOSTRAR UN REGSITRO

    public void delete(Integer id); // ELIMINAR REGISTRO
    
}
