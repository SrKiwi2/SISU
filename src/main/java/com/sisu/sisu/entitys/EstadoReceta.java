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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "estado_receta")
public class EstadoReceta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_receta")
    private Long idEstadoReceta;
    
    @Column(name = "estado")
    private String estado;

    @Column(name = "descripcion")
    private String descripcion;

    //-----------------RELACIONES-----------------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado_receta", fetch = FetchType.LAZY)
	private List<Receta> receta;
}
