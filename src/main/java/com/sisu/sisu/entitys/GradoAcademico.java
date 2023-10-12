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

@Getter
@Setter
@Entity
@Table(name = "grado_academico")
public class GradoAcademico implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = " id_grado_academico")
	private Long idGradoAcademico;

	@Column(name = "grado_academico")
	private String gradoAcademico;

	@Column(name = "estado")
	private String estado;

	@Column(name = "nivel_grado")
	private String nivel_grado;

	@Column(name = "simbolo")
	private String simbolo;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "status")
	private String status;


	@Column(name = "registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@Column(name = "modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;

	@Column(name = "observacion")
	private String observacion;


	//--------------------------RELACION--------------------------------------

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grado_academico", fetch = FetchType.LAZY)
	private List<Persona> persona;
	



}
