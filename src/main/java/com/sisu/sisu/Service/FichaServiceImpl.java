package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.FichaDao;
import com.sisu.sisu.entitys.Ficha;

@Service
public class FichaServiceImpl implements FichaService{

    @Autowired
    private FichaDao fichaDao;

    @Override
    public List<Ficha> findAll() {
       return (List<Ficha>) fichaDao.findAll();
    }

    @Override
    public void save(Ficha ficha) {
        fichaDao.save(ficha);
    }

    @Override
    public Ficha findOne(Integer id) {
        
       return fichaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        
        fichaDao.deleteById(id);
    }
    
}
