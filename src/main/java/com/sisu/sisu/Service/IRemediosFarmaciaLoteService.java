package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.RemediosFarmaciaLote;

@Service
public interface IRemediosFarmaciaLoteService {
    public List<RemediosFarmaciaLote> findAll();
    public void save(RemediosFarmaciaLote remediosFarmaciaLote);
    public RemediosFarmaciaLote findOne(Long id);
    public void delete(Long id);
}
