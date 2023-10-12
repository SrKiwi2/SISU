package com.sisu.sisu.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Getter
@Setter
@Table(name = "usuarios")
public class Usuario {
	
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario")
  private Integer idUsuario;
 

  @Column(name = "apodo")
  private String apodo;
  
  @Column(name = "clave")
  private String clave;

  @Column(name = "estado")
  private String estado;
  
  @Column(name = "registro")
  @Temporal(TemporalType.TIMESTAMP)
  private Date registro;
  
  @Column(name = "modificacion")
  @Temporal(TemporalType.TIMESTAMP)
  private Date modificacion;
  
  @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
  @ManyToOne(optional = false)
  private Persona idPersona;

// public Usuarios() {
// 	super();
// 	// TODO Auto-generated constructor stub
// }

// public Usuarios(Integer idUsuario, String apodo, String clave, String estado, Date registro, Date modificacion,
// 		Persona idPersona) {
// 	super();
// 	this.idUsuario = idUsuario;
// 	this.apodo = apodo;
// 	this.clave = clave;
// 	this.estado = estado;
// 	this.registro = registro;
// 	this.modificacion = modificacion;
// 	this.idPersona = idPersona;
// }

// public Integer getIdUsuario() {
// 	return idUsuario;
// }

// public void setIdUsuario(Integer idUsuario) {
// 	this.idUsuario = idUsuario;
// }

// public String getApodo() {
// 	return apodo;
// }

// public void setApodo(String apodo) {
// 	this.apodo = apodo;
// }

// public String getClave() {
// 	return clave;
// }

// public void setClave(String clave) {
// 	this.clave = clave;
// }

// public String getEstado() {
// 	return estado;
// }

// public void setEstado(String estado) {
// 	this.estado = estado;
// }

// public Date getRegistro() {
// 	return registro;
// }

// public void setRegistro(Date registro) {
// 	this.registro = registro;
// }

// public Date getModificacion() {
// 	return modificacion;
// }

// public void setModificacion(Date modificacion) {
// 	this.modificacion = modificacion;
// }

// public Persona getIdPersona() {
// 	return idPersona;
// }

// public void setIdPersona(Persona idPersona) {
// 	this.idPersona = idPersona;
// }

// @Override
// public String toString() {
// 	return "Usuarios [idUsuario=" + idUsuario + ", apodo=" + apodo + ", clave=" + clave + ", estado=" + estado
// 			+ ", registro=" + registro + ", modificacion=" + modificacion + ", idPersona=" + idPersona + "]";
// }
 
  
  
}
  
  
