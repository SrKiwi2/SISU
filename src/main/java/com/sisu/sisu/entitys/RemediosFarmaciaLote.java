package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "remedios_farmacia_lote")
public class RemediosFarmaciaLote implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_remedios_farmacia_lote")
    private Integer idRemediosFarmaciaLote;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @Column(name = "precio_venta")
    private String precioVenta;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    @Column(name = "estado")
	private String estado;

    

    //---------------------------RELACIONES-------------------------------------

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRemedioLote")
    private RemedioLote remedio_lote;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRemediosFarmacia")
    private RemediosFarmacia remedios_farmacia;



}
