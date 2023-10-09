package com.sisu.sisu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.entitys.Persona;

@Controller
public class Personacontroller {
    @Autowired
    private IPersonaService personaService;
    
    @GetMapping(value = "/p")
    public String registroPersona(@Validated Persona persona, Model model){
        
        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", personaService.findAll());

        return "formularios/formPersona";
    }

    /* GUARDAR */

    @PostMapping(value = "/guardarPersona")
    public String RegistrarPersona(@Validated Persona persona){
        persona.setEstado("A");
        personaService.save(persona);
        return "redirect:/formRegistro";
    }

    /* eliminar */
    
    @RequestMapping(value = "/eliminarPersona/{idPersona}")
    public String eliminarPersona(@PathVariable("idPersona")Integer idPersona){
        Persona persona = personaService.findOne(idPersona);
        persona.setEstado("X");
        personaService.save(persona);
        return "redirect:/ListaPersona";
        
    }

    /* Editar */

    @RequestMapping(value = "/editarPersona/{idPersona}")
    public String editarPersona(@PathVariable("idPersona")Integer idPersona, Model model){
        Persona persona = personaService.findOne(idPersona);
        model.addAttribute("persona", persona);
        return "formularios/formPersona";
    }

    /* Lista  */
    
    @GetMapping(value = "/ListaPersona")
    public String listarPersona (Model model){
        model.addAttribute("personas", personaService.findAll());
        return "listas/listasP";
    }
}
