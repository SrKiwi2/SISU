package com.sisu.sisu.Service;


import java.util.List;

import com.sisu.sisu.entitys.Persona;

public interface IPersonaService {
    public List<Persona> findAll(); //Muestra todos los registros
    public void save(Persona persona); //Guarda registro
    public Persona findOne(Long id); //Muestra un registro
    public void delete(Long id); //Elimina registro
}
