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
@Table(name = "tipo_seguro")
public class TipoSeguro implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_seguro")
    private Long idTipoSeguro;

    @Column(name = "tipo_seguro")
    private String tipoSeguro;

    @Column(name = "descripcion_seguro")
    private String descripcionSeguro;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;
}
