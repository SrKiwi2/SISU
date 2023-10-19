package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class PersonaUsuarioController {

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
  
    



    @GetMapping(value = "/formPerUsuario") // Pagina principal
	public String registroPersona(Model model) {

    
        model.addAttribute("persona1", new Persona());
        model.addAttribute("personas1", personaService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", dipService.findAll());

        model.addAttribute("grado", new GradoAcademico());
        model.addAttribute("grados", gradoService.findAll());
		
        model.addAttribute("estadoCivil", new TiposEstadoCivil());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());

        return "";

		
	}


    @PostMapping(value = "/savePerUsuario") // Enviar datos de Registro a Lista
	public String guardarPersona(@Validated Persona persona1, RedirectAttributes flash,HttpServletRequest request,
    @RequestParam(name="apodo",required = false)String apodo,
    @RequestParam(name="clave",required = false)String clave,
    @RequestParam(name="grado",required = false)Long idGradoAcademico,
    @RequestParam(name="dip",required = false)Long idDip,
    @RequestParam(name="estadoCivil",required = false)Long idTipoEstadoCivil
    ) { 

        persona1.setEstado("A");
        persona1.setGrado_academico(gradoService.findOne(idGradoAcademico));
        persona1.setDip(dipService.findOne(idDip));
        persona1.setTipos_estado_civil(estadoCivilService.findOne(idTipoEstadoCivil));
        personaService.save(persona1); // guardas todos los datos de la persona (1)

        Usuario usuario = new Usuario(); // creas un nuevo registro de usuario 
        usuario.setApodo(apodo);
        usuario.setClave(clave);
        usuario.setEstado("A");

        usuario.setPersona(persona1);// aqui ya creas la relacion de la Persona con el Usuario (1)
        usuarioService.save(usuario);
		personaService.save(persona1);

		return "redirect:/listaPerUsuario";
	}

        @PostMapping(value = "/SavePerUsuario") // Enviar datos de Registro a Lista
        public String guardarPersona_2(RedirectAttributes flash,HttpServletRequest request,
        @RequestParam(name = "idPersona") Long id_persona,
        @RequestParam(name = "idUsuario") Long idUsuario,
        @RequestParam(name = "nombres") String nombres,
        @RequestParam(name = "apPaterno") String apPaterno,
        @RequestParam(name = "apMaterno") String apMaterno,
        @RequestParam(name = "ci") String ci,
        @RequestParam(name = "celular") Integer celular,
        @RequestParam(name = "Direccion") String Direccion,
        @RequestParam(name = "apodo") String apodo,
        @RequestParam(name = "clave") String clave,
        @RequestParam(name="grado",required = false)Long idGradoAcademico,
        @RequestParam(name="dip",required = false)Long idDip,
        @RequestParam(name="estadoCivil",required = false)Long idTipoEstadoCivil
        ) { 

            Persona persona = personaService.findOne(id_persona);

            persona.setNombres(nombres);
            persona.setApPaterno(apPaterno);
            persona.setApMaterno(apMaterno);
            persona.setCi(ci);
            persona.setEstado("A");
            persona.setGrado_academico(gradoService.findOne(idGradoAcademico));
            persona.setDip(dipService.findOne(idDip));
            persona.setTipos_estado_civil(estadoCivilService.findOne(idTipoEstadoCivil));
            personaService.save(persona); // guardas todos los datos de la persona (1)

            Usuario usuario = usuarioService.findOne(idUsuario); // creas un nuevo registro de usuario 
            
            usuario.setPersona(persona);
            usuario.setApodo(apodo);
            usuario.setClave(clave);
            usuarioService.save(usuario);

            return "redirect:/listaPerUsuario";
        }



    
    @GetMapping(value="/listaPerUsuario")
    public String listaUs(Model model, @Validated Persona persona1, Usuario usuario) {

        model.addAttribute("persona1", new Persona());
        model.addAttribute("personas1", personaService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios1", usuarioService.findAll());

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", dipService.findAll());

        model.addAttribute("grado", new GradoAcademico());
        model.addAttribute("grados", gradoService.findAll());

        model.addAttribute("estadoCivil", new TiposEstadoCivil());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());

       
        return "listas/listaPerUsuario";
    
    }


    //-------------------------EDITAR---------------------------------------

    @GetMapping(value="/editarPer/{idUsuario}")
   public String editarUs(Model model, @PathVariable("idUsuario") Long idUsuario) {
    
    // Obtener la persona y el usuario correspondientes al ID proporcionado
    
    Usuario usuario = usuarioService.findOne(idUsuario);
    Persona persona = personaService.findOne(usuario.getPersona().getIdPersona());

    // Asegurarse de que la persona y el usuario existen
    if (persona != null && usuario != null) {
        // Configurar el estado de la persona y el usuario si es necesario
        persona.setEstado("A");
        usuario.setEstado("A");

        // Agregar la persona y el usuario al modelo
        model.addAttribute("persona1", persona);
        model.addAttribute("usuario", usuario);

        // Agregar otros atributos al modelo si es necesario
        model.addAttribute("personas1", personaService.findAll());
        model.addAttribute("usuarios1", usuarioService.findAll());
        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", dipService.findAll());
        model.addAttribute("grado", new GradoAcademico());
        model.addAttribute("grados", gradoService.findAll());
        model.addAttribute("estadoCivil", new TiposEstadoCivil());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());

        return "listas/listaPerUsuario";
    } else {
        // Manejo de errores si la persona o el usuario no existen
        return "redirect:/paginaDeError"; // Reemplaza "paginaDeError" por tu página de manejo de errores
    }
  }


   @RequestMapping(value = "/usuario/{idUsuario}")
    public String getContent1(@PathVariable(value = "idUsuario") Long idUsuario, Model model,
            HttpServletRequest request) {

        Usuario usuario = usuarioService.findOne(idUsuario);
                
        model.addAttribute("usuario", usuario);
        model.addAttribute("persona1", personaService.findOne(usuario.getPersona().getIdPersona()));
        model.addAttribute("dips", dipService.findAll());
        model.addAttribute("grados", gradoService.findAll());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());

        return "content :: content2";
    }


    //-------------------------ELIMINAR---------------------------------------
    
    @RequestMapping(value = "/eliminarUsuario/{idUsuario}")
    public String eliminarPersona(@PathVariable("idUsuario")Long idUsuario){
        Usuario usuario = usuarioService.findOne(idUsuario);
        Persona persona = personaService.findOne(usuario.getIdUsuario());
        persona.setEstado("X");
        usuario.setEstado("X");
        personaService.save(persona);
        usuarioService.save(usuario);
        return "redirect:/listaPerUsuario";
    }
}
