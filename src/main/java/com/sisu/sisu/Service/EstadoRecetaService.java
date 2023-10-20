package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.EstadoReceta;

@Service
public interface EstadoRecetaService {

    public List<EstadoReceta> findAll(); // Muestra todos los registros

    public void save(EstadoReceta EstadoReceta); // Guarda registro

    public EstadoReceta findOne(Long id); // Muestra un registro

    public void delete(Long id); // Elimina registro
}
