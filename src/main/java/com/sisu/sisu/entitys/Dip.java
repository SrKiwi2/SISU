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

@Entity
@Table(name = "dip")
public class Dip implements Serializable {

	// attributes
	/*
	 * idDip
	 * codDip
	 * descripcion
	 * estado
	 * 
	 * 
	 * registro
	 * modificacion
	 */

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dip")
	private Integer idDip;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "dip")
	private String codDip;

	@Column(name = "estado")
	private String estado;

	@Column(name = "registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@Column(name = "modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;

	// CONSTRUCTOR VACIO

	public Dip() {

	}

	// CONTRUCTOR

	public Dip(Integer idDip, String codDip, String descripcion, String estado, Date registro, Date modificacion) {
		super();
		this.idDip = idDip;
		this.codDip = codDip;
		this.descripcion = descripcion;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
	}

	// METODOS SETTETS y GETTERS

	public Integer getIdDip() {
		return idDip;
	}

	public void setIdDip(Integer idDip) {
		this.idDip = idDip;
	}


	public String getCodDip() {
		return codDip;
	}

	public void setCodDip(String codDip) {
		this.codDip = codDip;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

	public Date getModificacion() {
		return modificacion;
	}

	public void setModificacion(Date modificacion) {
		this.modificacion = modificacion;
	}

}
