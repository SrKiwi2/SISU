package com.sisu.sisu.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "receta_remedios")
public class RecetaRemedios implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta_remedios")
    private Long idRecetaRemedios;

    @Column(name = "estado")
    private String estado;

    //-----------------RELACIONES-----------------------------------------------

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idReceta")
    private Receta receta;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRemediosFarmacia")
    private RemediosFarmacia remedios_farmacia;

}
