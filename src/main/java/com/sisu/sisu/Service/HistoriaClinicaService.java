package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sisu.sisu.entitys.HistoriaClinica;

@Service
public interface HistoriaClinicaService {

    public List<HistoriaClinica> findAll(); //Muestra todos los registros
    public void save(HistoriaClinica dip); //Guarda registro
    public HistoriaClinica findOne(Long id); //Muestra un registro
    public void delete(Long id); //Elimina registro
    
}
