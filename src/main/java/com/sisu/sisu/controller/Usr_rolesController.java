package com.sisu.sisu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.Service.UsrRolesService;
import com.sisu.sisu.Service.UsuarioService;
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
    
    @GetMapping(value = "/ListaUsr")
    public String listaUs(Model model, @Validated Usuario usuarios) {

        model.addAttribute("usr_roles", new UsrRoles());
        model.addAttribute("usrroles1", usrrolesservice.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("rol", new Roles());
        model.addAttribute("roles", iRolesService.findAll());

        return "listas/ListaUsr";

    }


}
