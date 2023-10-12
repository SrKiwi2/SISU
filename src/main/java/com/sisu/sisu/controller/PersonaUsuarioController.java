package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class PersonaUsuarioController {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private UsuarioService usuarioService;

    // @GetMapping(value = "/formPerUsuario") // Pagina principal
	// public String registroPersona(@Validated Persona persona, Model model) {

    
    //     model.addAttribute("persona1", new Persona());
	// 	model.addAttribute("personas1" , personaService.findAll()); 


	// 	model.addAttribute("usuario", new Usuario());
	// 	model.addAttribute("usuarios", usuarioService.findAll());
		
    //     return "";

		
	// }


    @PostMapping(value = "/savePerUsuario") // Enviar datos de Registro a Lista
	public String guardarPersona(@Validated Persona persona1, RedirectAttributes flash,HttpServletRequest request,
    @RequestParam(name="apodo",required = false)String apodo,
    @RequestParam(name="clave",required = false)String clave
    ) { 
		persona1.setEstado("A");
        
        personaService.save(persona1); // guardas todos los datos de la persona (1)


        Usuario usuario = new Usuario(); // creas un nuevo registro de usuario 
        usuario.setApodo(apodo);
        usuario.setClave(clave);
        usuario.setEstado("A");
		
        usuario.setIdPersona(persona1);// aqui ya creas la relacion de la Persona con el Usuario (1)

        usuarioService.save(usuario);

		personaService.save(persona1);

		return "redirect:/listaPerUsuarios";
	}


    
    @GetMapping(value="/listaPerUsuario")
    public String listaUs(Model model, @Validated Usuario usuario, Persona persona) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());
        
        model.addAttribute("persona1", new Persona());
        model.addAttribute("personas1", personaService.findAll());

        return "listas/listaPerUsuario";
    
    }
    
}
