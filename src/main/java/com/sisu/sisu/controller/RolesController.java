package com.sisu.sisu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.entitys.Roles;

@Controller
public class RolesController {
    
    @Autowired
    private IRolesService rolesService;

    @GetMapping(value = "/formRegristroRoles")
    public String registroRoles(@Validated Roles roles, Model model) {
        model.addAttribute("role", new Roles());
        model.addAttribute("roles", rolesService.findAll());

        return "formularios/formRoles";
    }

    @PostMapping(value = "/guardarRoles")
    public String RegistroRol(@Validated Roles roles){
        roles.setEstado("A");
        rolesService.save(roles);
        return "redirect:/formRegristroRoles";
    }

    @RequestMapping(value = "/eliminarRoles/{idRol}")
    public String eliminarRol(@PathVariable("idRol") Integer idRol){
        Roles roles = rolesService.findOne(idRol);
        roles.setEstado("X");
        rolesService.save(roles);
        return "redirect:/ListaDeRoles";
    }

    @RequestMapping(value = "/editarRoles/{idRol}")
    public String editarRol(@PathVariable("idRol") Integer idRol, Model model){
        Roles roles = rolesService.findOne(idRol);
        model.addAttribute("role", roles);
        return "formularios/formRoles";
    }

    @GetMapping(value = "/ListaDeRoles")
    public String listarRol(Model model){
        model.addAttribute("roles", rolesService.findAll());
        return "listas/listaRoles";
    }
}
