package com.sisu.sisu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.entitys.Roles;

@Controller

public class RolControler {
    
    @Autowired
    private IRolesService iRolesService;


    //-------------------------GUARDAR---------------------------------------
    
    @PostMapping(value="/guardar_rol")
    public String guardar_rol(@Validated Roles roles) {

        roles.setEstado("A");

        iRolesService.save(roles);

        return "redirect:/listaRoles";
    }

    
    //-------------------------LISTAR---------------------------------------

    @GetMapping(value="/listaRoles")
    public String listarRoles(Model model, @Validated Roles roles) {

        model.addAttribute("rol", new Roles());
        model.addAttribute("roles", iRolesService.findAll());
        
        return "listas/listaRoles";
    }

    //-------------------------EDITAR---------------------------------------

    @GetMapping(value="/editarroles/{id_rol}")
    public String editarRol(Model model, @PathVariable("id_rol") Integer id_rol) {

        Roles roles = iRolesService.findOne(id_rol);

        roles.setEstado("A");

        model.addAttribute("rol", new Roles());
        model.addAttribute("roles", iRolesService.findAll());

        return "/listaRoles";
    }

    //-------------------------ELIMINAR---------------------------------------

    @GetMapping(value="/eliminarRol/{id_rol}")
    public String deleteRol(@PathVariable("id_rol") Integer id_rol) {

        Roles roles = iRolesService.findOne(id_rol);

        roles.setEstado("X");

        iRolesService.save(roles);

        return "redirect:/listaRoles";

    }


}
