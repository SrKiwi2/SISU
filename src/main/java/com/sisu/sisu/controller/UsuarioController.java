package com.sisu.sisu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.Usuarios;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IPersonaService personaService;

    @GetMapping(value="/formUs")
    public String vistaUs(Model model) {

        model.addAttribute("usuario", new Usuarios());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", personaService.findAll());

        return "usuarios";
    }


    //-------------------------GUARDAR---------------------------------------
    
    @PostMapping(value="/saveUs")
    public String saveUsiario(@Validated Usuarios usuarios) {

        usuarios.setEstado("A");

        usuarioService.save(usuarios);

        return "";
    }

    //-------------------------LISTAR---------------------------------------

    @GetMapping(value="/listaUs")
    public String listaUs(Model model) {

        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("personas", personaService.findAll());

        return "usuarios";
    
    }

    //-------------------------EDITAR---------------------------------------

    @GetMapping(value="/editarUs/{idUsuario}")
    public String editarUs(Model model, @PathVariable("idUsuario") Integer idUsuario) {

        Usuarios usuario = usuarioService.findOne(idUsuario);

        usuario.setEstado("A");

        model.addAttribute("usuario", new Usuarios());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", personaService.findAll());


        return "usuarios";
    }

    //-------------------------ELIMINAR---------------------------------------

    @GetMapping(value="/eliminarUs/{idUsuario}")
    public String deleteUs(@PathVariable("idUsuario") Integer idUsuario) {

        Usuarios usuario = usuarioService.findOne(idUsuario);

        usuario.setEstado("X");

        usuarioService.save(usuario);

        return "";

    }

}
