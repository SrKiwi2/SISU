package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.AseguradoDao;
import com.sisu.sisu.entitys.Asegurado;

@Service
public class AseguradoServiceImpl implements AseguradoService{

    @Autowired
    private AseguradoDao aseguradoDao;

    @Override
    public List<Asegurado> findAll() {
       return (List<Asegurado>) aseguradoDao.findAll();
    }

    @Override
    public void save(Asegurado asegurado) {  
        aseguradoDao.save(asegurado);
    }

    @Override
    public Asegurado findOne(Integer id) {
        return aseguradoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        aseguradoDao.deleteById(id);
    }

    @Override
    public Asegurado obtenerIdAsegurado(Integer id) {
        return aseguradoDao.obtenerIdAsegurado(id);
    }

    

}
