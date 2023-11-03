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

@Getter
@Setter
@Entity
@Table(name = "tipo_receta")
public class TipoReceta implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_receta")
    private Integer idTipoRe;

    @Column(name = "descripcion_receta")
    private String descripcionReceta;

     @Column(name = "vigencia_receta")
    private String vigencia_receta;

    @Column(name = "estado")
    private String estado;
    
    @Column(name = "registro")
    private String registro;
    
    @Column(name = "modificacion")  
    private String modificacion;    

    //-------------------RELACIONES---------------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo_receta", fetch = FetchType.LAZY)
	private List<Receta> receta;
    
}

