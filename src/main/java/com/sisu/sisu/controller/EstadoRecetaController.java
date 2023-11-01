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

import com.sisu.sisu.Service.EstadoRecetaService;
import com.sisu.sisu.entitys.EstadoReceta;
import com.sisu.sisu.entitys.ListaLiname;
import com.sisu.sisu.entitys.RemediosFarmacia;

@Controller
public class EstadoRecetaController {

    @Autowired
    private EstadoRecetaService estadoRecetaService;

    /* obtener */
    @GetMapping(value = "/formEstadoR")
    public String registroFormR(@Validated EstadoReceta estadoReceta, Model model) {

        model.addAttribute("estadoReceta", new EstadoReceta());
        model.addAttribute("estadosReceta", estadoRecetaService.findAll());

        return "formularios/formEstadoReceta";
    }

    /* guardar */
    @PostMapping(value = "/guardarEstadoR")
    public String RegistrarEstadoR(@Validated EstadoReceta estadoReceta) {
        estadoReceta.setEstado("A");
        estadoRecetaService.save(estadoReceta);
        return "redirect:/ListaEstadoR";
    }

    /* editar */
    @RequestMapping(value = "/editarEdtador/{idEstadoReceta}")
    public String editarEstadoR(@PathVariable("idEstadoReceta") Long idEstadoReceta, Model model) {
        EstadoReceta estadoReceta = estadoRecetaService.findOne(idEstadoReceta);
        model.addAttribute("estadoReceta", estadoReceta);
        return "formularios/formEstadoReceta";
    }

    /* Eliminar */

    @RequestMapping(value = "/eliminarEstadoR/{idEstadoReceta}")
    public String eliminarEstadoR(@PathVariable("idEstadoReceta") Long idEstadoReceta) {
        EstadoReceta estadoReceta = estadoRecetaService.findOne(idEstadoReceta);
        estadoReceta.setEstado("X");
        estadoRecetaService.save(estadoReceta);
        return "redirect:/ListaEstadoR";

    }

    /* lista */
    @GetMapping(value = "/ListaEstadoR")
    public String listarEstadoR(Model model) {

        model.addAttribute("estadosReceta", estadoRecetaService.findAll());

        return "listas/listaEstadoReceta";
    }

     /* modificar con el modal */

    @RequestMapping(value = "/estadoReceta/{idEstadoReceta}")
    public String getContentRemediosF(@PathVariable(value = "idEstadoReceta") Long idEstadoReceta, Model model,
        HttpServletRequest request){
            model.addAttribute("estadosReceta", estadoRecetaService.findOne(idEstadoReceta));
            
            return "contentRE :: contentEstadoReceta";
        }

    /* Registrar con el modal */

    @RequestMapping(value = "/registrarEstadoReceta")
    public String getRegistroEstadoReceta(Model model) {
        model.addAttribute("estadoReceta", new EstadoReceta());
        model.addAttribute("estadosReceta", estadoRecetaService.findAll());

        return "contentRE :: contentEstadoReceta";
    }

}
