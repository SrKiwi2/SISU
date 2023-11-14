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
@Table(name = "medico_servicio")
public class MedicoServicio implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico_servicio")
    private Integer idMedicoServicio;

    @Column(name = "fecha_asignacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignaqcion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medico_servicio", fetch = FetchType.LAZY)
	private List<PersonalMedico> personalMedico;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idServicioMedico")
    private ServicioMedico servicio_medico;


     @OneToMany(cascade = CascadeType.ALL, mappedBy = "medico_servicio", fetch = FetchType.LAZY)
	private List<HistorialMedicoServicio> historialMedicoServicio;

}
