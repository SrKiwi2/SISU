package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sisu.sisu.entitys.Asegurado;

public interface AseguradoService {

    public List<Asegurado> findAll(); //Muestra todos los registros

    public void save(Asegurado asegurado); //Guarda registro

    public Asegurado findOne(Integer id); //Muestra un registro

    public void delete(Integer id); //Elimina registro

    Asegurado obtenerIdAsegurado(@Param("id") Integer id);
    
}
