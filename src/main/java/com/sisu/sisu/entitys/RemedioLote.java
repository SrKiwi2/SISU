package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.time.LocalDate;
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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "remedio_lote")
public class RemedioLote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_remedio_lote")
    private Long idRemedioLote;

    @Column(name = "precio_lote")
    private String precioLote;

    @Column(name = "fecha_vencimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaVencimiento;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "numero_lote")
    private String numeroLote;

    @Column(name = "estado_remedioL")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;


    //----------------------RELACIONES------------------------------------------


    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "remedio_lote", fetch = FetchType.LAZY)
	// private List<RemediosFarmaciaLote> remedios_farmacia_lote;

    // @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "servicios")
    // private Proveedor servicios;
}
