package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.EstadoRecetaDao;
import com.sisu.sisu.entitys.EstadoReceta;

@Service
public class EstadoRecetaServiceImpl implements EstadoRecetaService {
    @Autowired

    private EstadoRecetaDao EstadoRecetaDao;

    @Override
    public List<EstadoReceta> findAll() {
        return (List<EstadoReceta>) EstadoRecetaDao.findAll();
    }

    @Override
    public void save(EstadoReceta tipo_receta) {
        EstadoRecetaDao.save(tipo_receta);

    }

    @Override
    public EstadoReceta findOne(Long id) {
        return EstadoRecetaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        EstadoRecetaDao.deleteById(id);
    }
}
