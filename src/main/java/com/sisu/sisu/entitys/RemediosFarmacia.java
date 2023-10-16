package com.sisu.sisu.entitys;

import java.io.Serializable;
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

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "remedios_farmacia")
public class RemediosFarmacia implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_remedios_farmacia")
    private Long idRemediosFarmacia; 

    @Column(name = "ubicacion")
    private String ubicacion;

    //-------------------REALCIONES---------------------------------------------

    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "remedios_farmacia", fetch = FetchType.LAZY)
	private List<RemediosFarmaciaLote> remedios_farmacia_lote;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idLiname")
    private RemediosFarmacia lista_liname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "remedios_farmacia", fetch = FetchType.LAZY)
	private List<RecetaRemedios> receta_remedios;
}
