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

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "forma_farmaceutica")
public class FormaFarmaceutica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma_farmaceutica")
    private Long idFormaFarmaceutica;

    @Column(name = "nombre_forma_farmaceutica")
    private String nombreFormaFarmaceutica;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estadoFF")
    private String estadoFF;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;


    //------------------------RELACIONES----------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "forma_farmaceutica", fetch = FetchType.LAZY)
	private List<ListaLiname> lista_liname;
}
