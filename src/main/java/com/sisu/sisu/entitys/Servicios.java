package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "servicios")
public class Servicios implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idServicio;

    @Column(name = "servicio")
    private Integer serviacio;

    @Column(name = "descripcion")
    private Integer descripcion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    // --------------------------RELACION--------------------------------------


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicios", fetch = FetchType.LAZY)
	private List<ServicioMedico> servicioMedico;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicios", fetch = FetchType.LAZY)
	private List<ConceptosServicios> conceptosServicios;

    //   @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicios", fetch = FetchType.LAZY)
	// private List<ConceptosServicios> receta;

}
