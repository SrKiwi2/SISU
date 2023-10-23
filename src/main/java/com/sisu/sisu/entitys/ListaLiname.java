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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "lista_liname")
public class ListaLiname implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_liname")
    private Long idLiname;

    @Column(name = "codigo_liname")
    private String codigoLiname;

    @Column(name = "fecha_incluido")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIncluido;

    @Column(name = "fecha_excluido")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaExcluido;

    @Column(name = "estado_liname")
    private String estadoLiname;

    @Column(name = "codigo_ATQ")
    private String codigoATQ;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;


    //--------------------REMEDIOS--------------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lista_liname", fetch = FetchType.LAZY)
	private List<RemediosFarmacia> remedios_farmacia;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lista_liname", fetch = FetchType.LAZY)
	private List<HistorialLiname> historial_liname;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFormaFarmaceutica")
    private FormaFarmaceutica forma_farmaceutica;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoUso")
    private TipoUso tipo_uso;

}
