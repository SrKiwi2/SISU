package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.GradoAcademico;

@Service
public interface IGradoService {

    public List<GradoAcademico> findAll(); // MOSTRAR TODOS LOS REGSITROS

    public void save(GradoAcademico gradoAcademico); // GUARDAR REGISTRO

    public GradoAcademico findOne(Long id); // MOSTRAR UN REGSITRO

    public void delete(Long id); // ELIMINAR REGISTRO

}
