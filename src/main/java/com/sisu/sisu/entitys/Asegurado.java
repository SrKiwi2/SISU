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
@Table(name = "asegurado")
public class Asegurado implements Serializable {
  private static long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_asegurado")
  private Integer idAsegurado;

  @Column(name = "estado")
  private String estado;

  @Column(name = "codigo_asegurado")
  private String codigoAsegurado;

  @Column(name = "registro")
  @Temporal(TemporalType.TIMESTAMP)
  private Date registro;

  @Column(name = "modificacion")
  @Temporal(TemporalType.TIMESTAMP)
  private Date modificacion;

  // ----------------------RELACIONES------------------------------------------

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "asegurado", fetch = FetchType.LAZY)
  private List<HistorialSeguro> historial_seguro;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idPersona")
  private Persona persona;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "asegurado", fetch = FetchType.LAZY)
  private List<HistorialMedico> historial_medico;

public Asegurado() {
	super();
	// TODO Auto-generated constructor stub
}

public Asegurado(Integer idAsegurado, String titular, String ru, String fecha_alta, String fecha_baja, String estado,
		String codigoSeguro, String codigoSeguroPrincipal, Date registro, Date modificacion,
		List<HistorialSeguro> historial_seguro, Persona persona, List<HistorialMedico> historial_medico) {
	super();
	this.idAsegurado = idAsegurado;
	this.titular = titular;
	this.ru = ru;
	this.fecha_alta = fecha_alta;
	this.fecha_baja = fecha_baja;
	this.estado = estado;
	this.codigoSeguro = codigoSeguro;
	this.codigoSeguroPrincipal = codigoSeguroPrincipal;
	this.registro = registro;
	this.modificacion = modificacion;
	this.historial_seguro = historial_seguro;
	this.persona = persona;
	this.historial_medico = historial_medico;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

public static void setSerialversionuid(long serialversionuid) {
	serialVersionUID = serialversionuid;
}

public Integer getIdAsegurado() {
	return idAsegurado;
}

public void setIdAsegurado(Integer idAsegurado) {
	this.idAsegurado = idAsegurado;
}

public String getTitular() {
	return titular;
}

public void setTitular(String titular) {
	this.titular = titular;
}

public String getRu() {
	return ru;
}

public void setRu(String ru) {
	this.ru = ru;
}

public String getFecha_alta() {
	return fecha_alta;
}

public void setFecha_alta(String fecha_alta) {
	this.fecha_alta = fecha_alta;
}

public String getFecha_baja() {
	return fecha_baja;
}

public void setFecha_baja(String fecha_baja) {
	this.fecha_baja = fecha_baja;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public String getCodigoSeguro() {
	return codigoSeguro;
}

public void setCodigoSeguro(String codigoSeguro) {
	this.codigoSeguro = codigoSeguro;
}

public String getCodigoSeguroPrincipal() {
	return codigoSeguroPrincipal;
}

public void setCodigoSeguroPrincipal(String codigoSeguroPrincipal) {
	this.codigoSeguroPrincipal = codigoSeguroPrincipal;
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

public List<HistorialSeguro> getHistorial_seguro() {
	return historial_seguro;
}

public void setHistorial_seguro(List<HistorialSeguro> historial_seguro) {
	this.historial_seguro = historial_seguro;
}

public Persona getPersona() {
	return persona;
}

public void setPersona(Persona persona) {
	this.persona = persona;
}

public List<HistorialMedico> getHistorial_medico() {
	return historial_medico;
}

public void setHistorial_medico(List<HistorialMedico> historial_medico) {
	this.historial_medico = historial_medico;
}

@Override
public String toString() {
	return "Asegurado [idAsegurado=" + idAsegurado + ", titular=" + titular + ", ru=" + ru + ", fecha_alta="
			+ fecha_alta + ", fecha_baja=" + fecha_baja + ", estado=" + estado + ", codigoSeguro=" + codigoSeguro
			+ ", codigoSeguroPrincipal=" + codigoSeguroPrincipal + ", registro=" + registro + ", modificacion="
			+ modificacion + ", historial_seguro=" + historial_seguro + ", persona=" + persona + ", historial_medico="
			+ historial_medico + "]";
}
  
  
  
  
  
  
  
  
  
  
  
  

}
