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
@Table(name = "concepto_servicio")
public class ConceptosServicios implements Serializable {
    private static long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_concepto_servicio")
    private Integer idConceptoServicio;

    @Column(name = "servicio")
    private String servicio;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo")
    private float costo;

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

	public ConceptosServicios() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConceptosServicios(Integer idConceptoServicio, String servicio, String descripcion, float costo,
			String estado, Date registro, Date modificacion, Servicio servicios,
			List<HistorialMedico> historial_medico) {
		super();
		this.idConceptoServicio = idConceptoServicio;
		this.servicio = servicio;
		this.descripcion = descripcion;
		this.costo = costo;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.servicios = servicios;
		this.historial_medico = historial_medico;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdConceptoServicio() {
		return idConceptoServicio;
	}

	public void setIdConceptoServicio(Integer idConceptoServicio) {
		this.idConceptoServicio = idConceptoServicio;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
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

	public Servicio getServicios() {
		return servicios;
	}

	public void setServicios(Servicio servicios) {
		this.servicios = servicios;
	}

	public List<HistorialMedico> getHistorial_medico() {
		return historial_medico;
	}

	public void setHistorial_medico(List<HistorialMedico> historial_medico) {
		this.historial_medico = historial_medico;
	}

	@Override
	public String toString() {
		return "ConceptosServicios [idConceptoServicio=" + idConceptoServicio + ", servicio=" + servicio
				+ ", descripcion=" + descripcion + ", costo=" + costo + ", estado=" + estado + ", registro=" + registro
				+ ", modificacion=" + modificacion + ", servicios=" + servicios + ", historial_medico="
				+ historial_medico + "]";
	}
	
	
	
	
	
	

}
