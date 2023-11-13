package com.sisu.sisu.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.Enlace;

public interface EnlaceDao extends CrudRepository<Enlace, Integer>{

    @Query("select L from Enlace L where L.obs  = '0' and L.estado='A'")
    List<Enlace>listaEnlacePadre();

    @Query("select e from Enlace e where e.obs  = '1' and e.estado='A' and e.tabla=?1")
    List<Enlace>listaEnlaceHijo(int idEnlacePadre);

} 
