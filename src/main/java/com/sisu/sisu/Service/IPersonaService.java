package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.Persona;

@Service
public interface IPersonaService {
    public List<Persona> findAll(); // Muestra todos los registros

    public void save(Persona persona); // Guarda registro

    public Persona findOne(Integer id); // Muestra un registro
    
    public void delete(Integer id); // Elimina registro

    public Persona findByCi(String ci);

    Persona validarCI(@Param("ci") String ci);
}
