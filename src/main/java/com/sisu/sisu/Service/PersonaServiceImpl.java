package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.IPersonaDao;
import com.sisu.sisu.entitys.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaDao personaDao;

    @Override
    public List<Persona> findAll() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    public void save(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    public Persona findOne(Integer id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        personaDao.deleteById(id);
    }

    @Override
    public Persona findByCi(String ci) {
        return personaDao.findByCi(ci);
    }
}
