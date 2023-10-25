package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.TiposEstadoCivil;

@Service
public interface ITiposEstadoCivilService {
    public List<TiposEstadoCivil> findAll(); // Muestra todos los registros

    public void save(TiposEstadoCivil TiposEstadoCivil); // Guarda registro

    public TiposEstadoCivil findOne(Long id); // Muestra un registro

    public void delete(Long id); // Elimina registro
}