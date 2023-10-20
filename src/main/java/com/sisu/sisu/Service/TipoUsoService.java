package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.TipoUso;

public interface TipoUsoService {
    
    public List<TipoUso> findAll();

    public void save(TipoUso tipoUso);

    public TipoUso findOne(Long id);

    public void delete(Long id);
}
