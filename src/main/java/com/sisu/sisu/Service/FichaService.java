package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.Ficha;

public interface FichaService {

    public List<Ficha> findAll(); //Muestra todos los registros

    public void save(Ficha ficha); //Guarda registro

    public Ficha findOne(Integer id); //Muestra un registro

    public void delete(Integer id); //Elimina registro

}
