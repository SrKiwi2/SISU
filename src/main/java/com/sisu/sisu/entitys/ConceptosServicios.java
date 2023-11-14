package com.sisu.sisu.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "concepto_servicio")
public class ConceptosServicios {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_concepto_servicio")
    private Integer idConceptoServicio;

    @Column(name = "servicio")
    private Integer servicio;

    @Column(name = "descripcion")
    private Integer descripcion;

    @Column(name = "costo")
    private Integer costo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    // --------------------------RELACION--------------------------------------
    // @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "servicios")
    // private Proveedor servicios;
}
