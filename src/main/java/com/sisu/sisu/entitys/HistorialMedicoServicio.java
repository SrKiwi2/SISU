package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "historial_medico_servicio")
public class HistorialMedicoServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial_medico_servicio")
    private Integer idHistorialMedicoServicio;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    /* RELACIONES */

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "idAtencionMedica")
    // private AtencionMedica atencion_medica;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "idAsegurado")
    // private Asegurado asegurado;

}
