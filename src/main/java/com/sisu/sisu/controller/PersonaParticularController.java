package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.EstadoCivilService;
import com.sisu.sisu.Service.IDipService;
import com.sisu.sisu.Service.IGradoService;
import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Dip;
import com.sisu.sisu.entitys.GradoAcademico;
import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.TiposEstadoCivil;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class PersonaParticularController {


     @Autowired
    private IPersonaService personaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IDipService dipService;

    @Autowired
    private IGradoService gradoService;

    @Autowired
    private EstadoCivilService estadoCivilService;


     ///////////////////////////////////////////////////////////////////////////////////////////////////
    //-----------------------------------Perosna Particular---------------------------------------------


     @GetMapping(value = "/formPerParticular") // Pagina principal
	public String registroPersonaParticuar(Model model) {

    
        model.addAttribute("personaP", new Persona());
        model.addAttribute("personasP", personaService.findAll());

        model.addAttribute("usuarioP", new Usuario());
        model.addAttribute("usuariosP", usuarioService.findAll());

        model.addAttribute("dipP", new Dip());
        model.addAttribute("dipsP", dipService.findAll());

        model.addAttribute("gradoP", new GradoAcademico());
        model.addAttribute("gradosP", gradoService.findAll());
		
        model.addAttribute("estadoCivilP", new TiposEstadoCivil());
        model.addAttribute("estadosCivilesP", estadoCivilService.findAll());

        return "index/loginS";

		
	}


    @PostMapping(value = "/savePerParticular") // Enviar datos de Registro a Lista
	public String guardarPersonaParticular(@Validated Persona personaP,BindingResult bindingResult, RedirectAttributes flash,HttpServletRequest request,
    @RequestParam(name="apodo",required = false)String apodo,
    @RequestParam(name="clave",required = false)String clave,
    @RequestParam(name="grado",required = false) Integer idGradoAcademico,
    @RequestParam(name="dip",required = false)Integer idDip,
    @RequestParam(name="estadoCivil",required = false)Long idTipoEstadoCivil
    ) { 

        personaP.setEstado("A");
        personaP.setGrado_academico(gradoService.findOne(idGradoAcademico));
        personaP.setDip(dipService.findOne(idDip));
        personaP.setTipos_estado_civil(estadoCivilService.findOne(idTipoEstadoCivil));
        personaService.save(personaP); // guardas todos los datos de la persona (1)

        Usuario usuarioP = new Usuario(); // creas un nuevo registro de usuario 
        usuarioP.setApodo(apodo);
        usuarioP.setClave(clave);
        usuarioP.setEstado("A");

        usuarioP.setPersona(personaP);// aqui ya creas la relacion de la Persona con el Usuario (1)
        usuarioService.save(usuarioP);
		personaService.save(personaP);

		return "redirect:/formPerParticular";
	}

    
}
