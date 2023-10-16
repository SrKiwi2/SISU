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
@Getter
@Setter
@Table(name = "asegurado")
public class Asegurado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asegurado")
    private Long idAsegurado;

    @Column(name = "titular")
    private String titular;

    @Column(name = "ru")
    private String ru;

    @Column(name = "fecha_alta")
    private String fecha_alta;

    @Column(name = "fecha_baja")
    private String fecha_baja;

    @Column(name = "estado")
    private String estado;

    @Column(name = "codigo_seguro")
    private String codigoSeguro;

    @Column(name = "codigo_seguro_principal")
    private String codigoSeguroPrincipal;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;


    //----------------------RELACIONES------------------------------------------

   
}

