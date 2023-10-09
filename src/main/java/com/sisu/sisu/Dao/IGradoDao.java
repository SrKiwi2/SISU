package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisu.sisu.entitys.GradoAcademico;

public interface IGradoDao extends JpaRepository<GradoAcademico, Long> {

}
