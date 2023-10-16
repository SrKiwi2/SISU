package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "lista_liname")
public class ListaLiname implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_liname")
    private Long idListaLiname;

    @Column(name = "codigo_liname")
    private String codigoLiname;

    @Column(name = "fecha_incluido")
    private Date fechaIncluido;

    @Column(name = "fecha_excluido")
    private Date fechaExcluido;

    @Column(name = "estado_liname")
    private String estadoLiname;

    @Column(name = "codigo_ATQ")
    private String codigoATQ;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

}
