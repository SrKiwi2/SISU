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

@Entity
@Table(name = "tipos_estado_civil")
public class TiposEstadoCivil implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_estado_civil")
	private Integer idTipoEstadoCivil;

	@Column(name = "estado_civil")
	private String estadoCivil;

	@Column(name = "estado")
	private String estado;

	@Column(name = "registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@Column(name = "modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;

	public TiposEstadoCivil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TiposEstadoCivil(Integer idTipoEstadoCivil, String estadoCivil, String estado, Date registro,
			Date modificacion) {
		super();
		this.idTipoEstadoCivil = idTipoEstadoCivil;
		this.estadoCivil = estadoCivil;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
	}

	public Integer getIdTipoEstadoCivil() {
		return idTipoEstadoCivil;
	}

	public void setIdTipoEstadoCivil(Integer idTipoEstadoCivil) {
		this.idTipoEstadoCivil = idTipoEstadoCivil;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
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

	@Override
	public String toString() {
		return "TiposEstadoCivil [idTipoEstadoCivil=" + idTipoEstadoCivil + ", estadoCivil=" + estadoCivil + ", estado="
				+ estado + ", registro=" + registro + ", modificacion=" + modificacion + "]";
	}

}
