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
@Table(name = "grado_academico")
public class GradoAcademico implements Serializable {
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = " id_grado_academico")
    private Integer idGradoAcademico;
    
    @Column(name = "grado_academico")
    private String gradoAcademico;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "simbolo")
    private String simbolo;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;
    
    @Column(name = "observacion")
    private String observacion;

	public GradoAcademico() {


		// TODO Auto-generated constructor stub
	}

	public GradoAcademico(Integer idGradoAcademico, String gradoAcademico, String estado, String simbolo,
			String descripcion, Date registro, Date modificacion, String observacion) {
		super();
		this.idGradoAcademico = idGradoAcademico;
		this.gradoAcademico = gradoAcademico;
		this.estado = estado;
		this.simbolo = simbolo;
		this.descripcion = descripcion;
		this.registro = registro;
		this.modificacion = modificacion;
		this.observacion = observacion;
	}

	public Integer getIdGradoAcademico() {
		return idGradoAcademico;
	}

	public void setIdGradoAcademico(Integer idGradoAcademico) {
		this.idGradoAcademico = idGradoAcademico;
	}

	public String getGradoAcademico() {
		return gradoAcademico;
	}

	public void setGradoAcademico(String gradoAcademico) {
		this.gradoAcademico = gradoAcademico;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
    
    
    
    
    
    
   

}
