package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica implements Serializable{
    
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historia_clinica")
	private Integer idHistoriaClinica;


   @Column(name = "fecha_registro_hc")
   Calendar calendario = Calendar.getInstance();
 private Date fechaAtencionMedica= calendario.getTime();
   
   

    @Column(name = "estado_Clinica")
    private String estadoHistoriaClinica;

    // ---------DATOS DEL INFORMANTE----------

    @Column(name = "relacion_infor")
	private String relacionInformante;

     @Column(name = "nombre_infor")
	private String nombreInformante;

     @Column(name = "domicilio_infor")
	private String domicilioInformante;


    // ----------SIGNOS VITALES-------------

     @Column(name = "peso")
	private float peso;

    @Column(name = "talla")
	private String talla;

    @Column(name = "presion_arterial")
	private float presiónArterial;

    @Column(name = "frecuencia_cardiaca")
	private Integer frecuenciaCardiaca;

     @Column(name = "frecuencia_respiratoria")
	private Integer frecuenciaRespiratoria;

     @Column(name = "temperatura_corporal")
	private float temperaturaCorporal;

    // ----------MOTIVO DE CONSULTA ; ENFERMEDAD ACTUAL-------------

    @Column(name = "motivo_consulta")
	private String motivoConsulta;

     @Column(name = "enfermedad_actual")
	private String enfermedadActual;

     // ----------Ant. Personales Patologicos ; Ant. Familiares Patologicos-------------

         @Column(name = "enf_congenitas")
	    private String enfCongenitas;

          @Column(name = "quirurgicos")
	    private String quirurgicos;

        @Column(name = "alergias_patologicos")
	    private String alergiasPatologicos;

         @Column(name = "patologias")
	    private String patologias;

          @Column(name = "antFamiliares_patologicos")
	    private String antFamiliaresPatologicos;

        // ----------Ant. Personales No Patologicos-------------

            @Column(name = "grupo_sanguineo")
	    private String grupoSanguineo;

          @Column(name = "alergias_No_patologicos")
	    private String alergiasNoPatologicos;

          @Column(name = "factores_riesgo")
	    private String factoresRiesgo;

// ----------Antecedentes Gineco-obstetricos-------------

            @Column(name = "menarca")
	    private Integer menarca;

          @Column(name = "menst_ritmo")
	    private String menstRitmo;

          @Column(name = "menopausia")
	    private String menopausia;

        @Column(name = "numero_embarazos")//G
	    private Integer numeroEmbarazos;

        @Column(name = "numero_partos")//P
	    private Integer numeroPartos;

        @Column(name = "numero_abortos")//A
	    private Integer numeroAbortos;

         @Column(name = "numero_cesarias")//A
	    private Integer numeroCesarias;

        @Column(name = "vida_sexual")
	    private String vidaSexual;

         @Column(name = "metodo_anticeptivo")
	    private String metodoAnticeptivo;

        // ----------ESTADO DEL PACIENTE IMPRESIÓN GENERAL-------------

        @Column(name = "estado_paciente")
	    private String estadoPaciente; 

          @Column(name = "cabeza")
	    private String cabeza;

         @Column(name = "cuello")
	    private String cuello;

         @Column(name = "torax")
	    private String torax;

           @Column(name = "abdomen")
	    private String abdomen;

            @Column(name = "extremidades")
	    private String extremidades;

        @Column(name = "neurologico")
	    private String neurologico;

        @Column(name = "examenes_complementarios")
	    private String examenesComplementarios;

        @Column(name = "diagnostico")
	    private String diagnostico;

        @Column(name = "tratamiento")
	    private String tratamiento;


}
