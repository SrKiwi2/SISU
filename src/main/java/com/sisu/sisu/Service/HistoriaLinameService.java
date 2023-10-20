package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.HistorialLiname;

public interface HistoriaLinameService {
    
    public List<HistorialLiname> findAll();

    public void save (HistorialLiname historiaLiname);

    public HistorialLiname findOne(Long id);

    public void delete (Long id);
}
