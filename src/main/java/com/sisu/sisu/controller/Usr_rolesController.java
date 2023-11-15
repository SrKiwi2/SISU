package com.sisu.sisu.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisu.sisu.Service.IRolesService;
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
    
    @GetMapping(value = "/ListaUsr")
    public String listaUs(Model model, @Validated UsrRoles usrRoles) {

        model.addAttribute("usrRoles", new UsrRoles());
        model.addAttribute("usrroles1", usrrolesservice.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("rol", new Roles());
        model.addAttribute("roles", iRolesService.findAll());

        return "listas/ListaUsr";

    }


    // -------------------------asignacion de rol---------------------------------------

    @GetMapping(value = "/asignacionrol/{idUsuario}")
    public String asignacion(Model model, @PathVariable("idUsuario") Integer idUsuario) {

        System.out.println("+++++++++++++++++++++++++1");

        Usuario usuario = usuarioService.findOne(idUsuario);

        if (usuario != null) {
            System.out.println(" no ES NULO " +"-"+ usuario.getPersona().getNombres() + usuario.getPersona().getApMaterno()
                    + usuario.getPersona().getDireccion() + usuario.getPersona().getEstado());
        } else {
            System.out.println("es nulo");
        }

        // System.out.println("+++++++++++++++++++++++++2"+usuario.getPersona().getNombres()+usuario.getPersona().getApMaterno()+usuario.getPersona().getDireccion()+usuario.getPersona().getEstado());

        usuario.setEstado_usuario("A");
        System.out.println("+++++++++++++++++++++++++3");
        model.addAttribute("usuario", new Usuario());
        System.out.println("+++++++++++++++++++++++++4");
        model.addAttribute("usuarios", usuario);
        System.out.println("+++++++++++++++++++++++++5");

        model.addAttribute("roles", iRolesService.findAll());
        System.out.println("el tamaño de la lista es" + iRolesService.findAll().size());

        return "listas/ListaPrueva";
    }

    @PostMapping("/obtenerrol")
    public String manejarFormulario(@RequestParam(name = "idUsuario") Integer idUsuario,
                                    @RequestParam(name = "solicitudesSeleccionadas", required = false)Integer [] solicitudesSeleccionadas)  {

        for (int i = 0; i < solicitudesSeleccionadas.length; i++) {

            
            Roles roles = iRolesService.findOne(solicitudesSeleccionadas[i]);

            Usuario usuario = usuarioService.findOne(idUsuario);

            System.out.println("el usuario:"+usuario.getPersona().getNombres()+" tiene el siguiente rol: "+ roles.getRol());

            UsrRoles usrRoles = new UsrRoles();

            usrRoles.setEstado("A");
            usrRoles.setModificacion(new Date());
            usrRoles.setRegistro(new Date());
            usrRoles.setIdRol(iRolesService.findOne(roles.getIdRol()));
            usrRoles.setIdUsuario(usuarioService.findOne(usuario.getIdUsuario()));
            usrrolesservice.save(usrRoles);


        }


        return "listas/ListaUsr";
    }









}
