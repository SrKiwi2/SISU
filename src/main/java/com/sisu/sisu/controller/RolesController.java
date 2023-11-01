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
        return "redirect:/ListaDeRoles";
    }

    @RequestMapping(value = "/eliminarRoles/{idRol}")
    public String eliminarRol(@PathVariable("idRol") Integer idRol){
        Roles roles = rolesService.findOne(idRol);
        roles.setEstado("X");
        rolesService.save(roles);
        return "redirect:/ListaDeRoles";
    }

    @GetMapping(value = "/ListaDeRoles")
    public String listarRol(Model model){
        model.addAttribute("roles", rolesService.findAll());
        return "listas/listaRoles";
    }

    /* modificar con el modal */
    @RequestMapping(value = "/roles/{idRol}")
    public String getContentRoless(@PathVariable(value = "idRol") Integer idRol, Model model,
            HttpServletRequest request) {
        model.addAttribute("role", rolesService.findOne(idRol));
        return "content :: contentRol";
    }

    /* registrar con el modal */
    @RequestMapping(value = "/registrarRoles")
    public String getRegistroRoles(Model model) {
        model.addAttribute("role", new Roles());
        model.addAttribute("roles", rolesService.findAll());
        return "content :: contentRol";
    }
}
