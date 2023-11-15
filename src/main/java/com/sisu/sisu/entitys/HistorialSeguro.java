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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "historial_seguro")
public class HistorialSeguro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial_seguro")
    private Integer idHistorialSeguro;

    @Column(name = "titularHS")
	private Boolean titularHS;

    @Column(name = "fecha_alta")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaAlta;

     @Column(name = "fecha_baja")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaBaja;

      @Column(name = "codigo_seguro_principal")
	private String codigoSeguroPrincipal;

      @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

//------------------Relaciones ------

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_seguro")
    private TipoSeguro tipo_seguro;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado_seguro")
    private EstadoSeguro estado_seguro;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_institucion")
    private Institucion institucion;

   @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_asegurado")
    private Asegurado asegurado;

}
