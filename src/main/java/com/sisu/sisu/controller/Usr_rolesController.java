package com.sisu.sisu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.Service.RolesServiceImpl;
import com.sisu.sisu.Service.UsrRolesService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.Roles;
import com.sisu.sisu.entitys.UsrRoles;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class Usr_rolesController {

    @Autowired
    private UsrRolesService usrrolesservice;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IRolesService iRolesService;


    //----------------------Metodo listar----------------------------

    // @GetMapping(value = "/lista_usr")
    // public String listar_usr(Model model, @Validated Usuario usuario){

    //     model.addAttribute("usuario", new Usuario());
    //     model.addAttribute("usuarios", usuarioService.findAll());

    //     model.addAttribute("rol", new Roles());
    //     model.addAttribute("roles", iRolesService.findAll());


    //     return "listas/ListaUsr";

    // }-------

    // @GetMapping(value="/listaRoles")
    // public String listarRoles(Model model, @Validated Roles roles) {

    //     model.addAttribute("rol", new Roles());
    //     model.addAttribute("roles", iRolesService.findAll());
        
    //     return "listas/listaRoles";
    // }
//------------------------------------------------------------------------------------------------


   

    // @GetMapping(value="/editarUs/{idUsuario}")
    // public String editarUs(Model model, @PathVariable("idUsuario") Long idUsuario) {

    //     Usuario usuario = usuarioService.findOne(idUsuario);

    //     usuario.setEstado("A");

    //     model.addAttribute("usuario", new Usuario());
    //     model.addAttribute("usuarios", usuarioService.findAll());

    //     model.addAttribute("persona", new Persona());
    //     model.addAttribute("personas", personaService.findAll());


    //     return "usuarios";
    // }

    
}
