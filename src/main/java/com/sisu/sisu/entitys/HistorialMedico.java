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
@Setter
@Getter
@Table(name = "historial_medico")
public class HistorialMedico implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_historial_medico")
  private Long idHistorialMedico;

  @Column(name = "observacion")
  private String Oberservacion;

  @Column(name = "fecha")
  private Date fecha;

  @Column(name = "estado")
  private String estado;

  @Column(name = "registro")
  @Temporal(TemporalType.TIMESTAMP)
  private Date registro;

  @Column(name = "modificacion")
  @Temporal(TemporalType.TIMESTAMP)
  private Date modificacion;

  // ----------------------RELACIONES------------------------------------------

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idAsegurado")
  private Asegurado asegurado;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idConceptoServicio")
  private ConceptosServicios concepto_servicio;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "historial_medico", fetch = FetchType.LAZY)
  private List<HistorialReceta> historial_receta;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "historial_medico", fetch = FetchType.LAZY)
  private List<HistorialMedicoServicio> historial_medico_servicio;


}
