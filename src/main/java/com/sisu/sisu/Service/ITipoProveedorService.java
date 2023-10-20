package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.TipoProveedor;

public interface ITipoProveedorService {
    public List<TipoProveedor> findAll();
    public void save(TipoProveedor tipoProveedor);
    public TipoProveedor findOne(Long id);
    public void delete(Long id);
}
