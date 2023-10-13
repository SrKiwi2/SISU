package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.TiposEstadoCivil;

@Service
public interface EstadoCivilService {

    public List<TiposEstadoCivil> findAll(); //MOSTRAR TODOS LOS REGSITROS

    public void save(TiposEstadoCivil estadoCivil);  //GUARDAR REGISTRO

    public TiposEstadoCivil findOne(Long id);  // MOSTRAR UN REGSITRO

    public void delete(Long id); // ELIMINAR REGISTRO
    
}
