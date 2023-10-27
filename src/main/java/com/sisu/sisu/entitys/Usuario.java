package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Usuario implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario")
  private Long idUsuario;

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

  public String getApodo() {
    return apodo;
  }

  // --------------------------RELACION--------------------------------------


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="idPersona")
  private Persona persona;

  // @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "idPersona")
  // private Persona persona;

}