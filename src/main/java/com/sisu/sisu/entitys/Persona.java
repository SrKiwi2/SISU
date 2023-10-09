package com.sisu.sisu.entitys;

import java.io.Serializable;
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

@Entity
@Table(name = "persona")
public class Persona implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;
	

    @Column(name = "nombres")
    private String nombres;
    
    @Column(name = "ap_paterno")
    private String apPaterno;
    
    @Column(name = "ap_materno")
    private String apMaterno;
    
    @Column(name = "ci")
    private String ci;
    
    @Column(name = "sexo")
    private String sexo;
    
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "celular")
    private Integer celular;
    
    @Column(name = "estado")
    private String estado;
    

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;
    
    
    @JoinColumn(name = "id_dip", referencedColumnName = "id_dip")
    @ManyToOne(optional = false)
    private Dip idDip;
    
    @JoinColumn(name = "id_tipo_estado_civil", referencedColumnName = "id_tipo_estado_civil")
    @ManyToOne(optional = false)
    private TiposEstadoCivil idTipoEstadoCivil;
    
    
    @JoinColumn(name = "id_grado_academico", referencedColumnName = "id_grado_academico")
    @ManyToOne(optional = false)
    private GradoAcademico idGradoAcademico;


	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Persona(Integer idPersona, String nombres, String apPaterno, String apMaterno, String ci, String sexo,
			String direccion, Integer celular, String estado, Date registro, Date modificacion, Dip idDip,
			TiposEstadoCivil idTipoEstadoCivil, GradoAcademico idGradoAcademico) {
		super();
		this.idPersona = idPersona;
		this.nombres = nombres;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.ci = ci;
		this.sexo = sexo;
		this.direccion = direccion;
		this.celular = celular;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.idDip = idDip;
		this.idTipoEstadoCivil = idTipoEstadoCivil;
		this.idGradoAcademico = idGradoAcademico;
	}


	public Integer getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApPaterno() {
		return apPaterno;
	}


	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}


	public String getApMaterno() {
		return apMaterno;
	}


	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}


	public String getCi() {
		return ci;
	}


	public void setCi(String ci) {
		this.ci = ci;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Integer getCelular() {
		return celular;
	}


	public void setCelular(Integer celular) {
		this.celular = celular;
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


	public Dip getIdDip() {
		return idDip;
	}


	public void setIdDip(Dip idDip) {
		this.idDip = idDip;
	}


	public TiposEstadoCivil getIdTipoEstadoCivil() {
		return idTipoEstadoCivil;
	}


	public void setIdTipoEstadoCivil(TiposEstadoCivil idTipoEstadoCivil) {
		this.idTipoEstadoCivil = idTipoEstadoCivil;
	}


	public GradoAcademico getIdGradoAcademico() {
		return idGradoAcademico;
	}


	public void setIdGradoAcademico(GradoAcademico idGradoAcademico) {
		this.idGradoAcademico = idGradoAcademico;
	}


	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombres=" + nombres + ", apPaterno=" + apPaterno + ", apMaterno="
				+ apMaterno + ", ci=" + ci + ", sexo=" + sexo + ", direccion=" + direccion + ", celular=" + celular
				+ ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion + ", idDip="
				+ idDip + ", idTipoEstadoCivil=" + idTipoEstadoCivil + ", idGradoAcademico=" + idGradoAcademico + "]";
	}
    
    
    
    
    

}
