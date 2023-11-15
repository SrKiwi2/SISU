package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "concepto_servicio")
public class ConceptosServicios implements Serializable {
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

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idServicio")
    private Servicio servicios;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "concepto_servicio", fetch = FetchType.LAZY)
	private List<HistorialMedico> historial_medico;

}
