package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.RemedioLote;

@Service
public interface IRemedioLoteService {
    public List<RemedioLote> findAll();
    public void save(RemedioLote remedioLote);
    public RemedioLote findOne(Long id);
    public void delete(Long id);
}
