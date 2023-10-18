package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.TiposEstadoCivil;

public interface ITiposEstadoCivilService {
    public List<TiposEstadoCivil> findAll(); // Muestra todos los registros

    public void save(TiposEstadoCivil TiposEstadoCivil); // Guarda registro

    public TiposEstadoCivil findOne(Integer id); // Muestra un registro

    public void delete(Integer id); // Elimina registro
}