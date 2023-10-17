package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.EstadoCivilService;
import com.sisu.sisu.Service.IDipService;
import com.sisu.sisu.Service.IGradoService;
import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.entitys.Dip;
import com.sisu.sisu.entitys.GradoAcademico;
import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.TiposEstadoCivil;

@Controller
public class Personacontroller {
    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IDipService dipService;

    @Autowired
    private IGradoService gradoService;

    @Autowired
    private EstadoCivilService estadoCivilService;
  
    
    @GetMapping(value = "/formRegistro")
    public String registroPersona(@Validated Persona persona, Model model){
        
        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", personaService.findAll());

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", dipService.findAll());

        model.addAttribute("grado", new GradoAcademico());
        model.addAttribute("grados", gradoService.findAll());
		
        model.addAttribute("estadoCivil", new TiposEstadoCivil());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());

        return "formularios/formPersona";
    }

    /* GUARDAR */

    @PostMapping(value = "/guardarPersona")
    public String RegistrarPersona(@Validated Persona persona, RedirectAttributes flash,HttpServletRequest request,

    @RequestParam(name="grado",required = false)Long idGradoAcademico,
    @RequestParam(name="dip",required = false)Long idDip,
    @RequestParam(name="estadoCivil",required = false)Long idTipoEstadoCivil
    ){
        persona.setEstado("A");
        persona.setGrado_academico(gradoService.findOne(idGradoAcademico));
        persona.setDip(dipService.findOne(idDip));
        persona.setTipos_estado_civil(estadoCivilService.findOne(idTipoEstadoCivil));
        personaService.save(persona);
        return "redirect:/formRegistro";
    }

    /* eliminar */
    
    @RequestMapping(value = "/eliminarPersona/{idPersona}")
    public String eliminarPersona(@PathVariable("idPersona")Long idPersona){
        Persona persona = personaService.findOne(idPersona);
        persona.setEstado("X");
        personaService.save(persona);
        return "redirect:/ListaPersona";
        
    }

    /* Obtener */
    @GetMapping(value = "/obtenerPersona/{idPersona}")
    public Persona obtenerPersona(@PathVariable(name = "idPersona",required = false) Long idPersona) {
        Persona persona = personaService.findOne(idPersona);
        System.out.println(persona.getNombres());
        return persona; // Spring Boot automáticamente convertirá esto en JSON
    }

    @GetMapping(value = "/obtenerPersona")
    public Persona obtenerPersona_v1(@RequestParam(name = "idPersona") Long idPersona) {
        Persona persona = personaService.findOne(idPersona);
        System.out.println(persona.getNombres());
        return persona;
    }


    /* Editar */

    @RequestMapping(value = "/editarPersona/{idPersona}")
    public String editarPersona(@PathVariable("idPersona")Long idPersona, Model model){
        Persona persona = personaService.findOne(idPersona);
        model.addAttribute("persona", persona);
        return "formularios/formPersona";
    }

    /* Lista  */
    
    @GetMapping(value = "/ListaPersona")
    public String listarPersona (Model model){
        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", personaService.findAll());

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", dipService.findAll());

        model.addAttribute("grado", new GradoAcademico());
        model.addAttribute("grados", gradoService.findAll());

        model.addAttribute("estadoCivil", new TiposEstadoCivil());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());

        return "listas/listasP";
    }
}
