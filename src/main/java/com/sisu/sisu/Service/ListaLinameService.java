package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.ListaLiname;

public interface ListaLinameService {
    
    public List<ListaLiname> findAll(); //MOSTRAR TODOS LOS REGSITROS

    public void save(ListaLiname listaLiname);  //GUARDAR REGISTRO

    public ListaLiname findOne(Long id);  // MOSTRAR UN REGSITRO

    public void delete(Long id); // ELIMINAR REGISTRO
}