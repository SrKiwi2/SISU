package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.Proveedor;

@Service
public interface IProveedorService {
    public List<Proveedor> findAll(); //Muestra todos los registros
    public void save(Proveedor proveedor); //Guarda registro
    public Proveedor findOne(Long id); //Muestra un registro
    public void delete(Long id); //Elimina registro
}
