package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.LinameDao;
import com.sisu.sisu.entitys.ListaLiname;

@Service
public class LinameServiceImpl implements LinameService{


    @Autowired
    private LinameDao linameDao;

    @Override
    public List<ListaLiname> findAll() {
         
        return (List<ListaLiname>) linameDao.findAll();
    }

    @Override
    public void save(ListaLiname liname) {
        
        linameDao.save(liname);
    }

    @Override
    public ListaLiname findOne(Long id) {
        
        return linameDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        
        linameDao.deleteById(id);
    }
    
}
