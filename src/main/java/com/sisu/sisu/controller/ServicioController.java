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

import com.sisu.sisu.Service.ServicioService;
import com.sisu.sisu.entitys.Servicio;

@Controller
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    /* guardar */
    @PostMapping(value = "/guardarServicioR")
    public String RegistrarServicioR(@Validated Servicio servicio) {
        servicio.setEstado("A");
        servicioService.save(servicio);
        return "redirect:/ListaEstadoR";
    }

    /* Eliminar */

    @RequestMapping(value = "/eliminarServicioR/{idServicio}")
    public String eliminarServicioR(@PathVariable("idServicio") Integer idServicio) {
        Servicio servicio = servicioService.findOne(idServicio);
        servicio.setEstado("X");
        servicioService.save(servicio);
        return "redirect:/ListaServicio";

    }

    /* lista */
    @GetMapping(value = "/ListaServicioR")
    public String listarEstadoR(Model model) {

        model.addAttribute("servicio", servicioService.findAll());

        return "listas/ListaServicio";
    }

    /* modificar con el modal */

    @RequestMapping(value = "/Servicio/{idServicio}")
    public String getContentEstadoServicio(@PathVariable(value = "idServicio") Integer idServicio, Model model,
            HttpServletRequest request) {
        model.addAttribute("Servicio", servicioService.findOne(idServicio));

        return "contentRE :: contentServicio";
    }
    /* Registrar con el modal */

    @RequestMapping(value = "/registrarServicio")
    public String getRegistroServicio(Model model) {
        model.addAttribute("Servicio", new Servicio());
        model.addAttribute("Servicio", servicioService.findAll());

        return "contentRE :: contentServicio";
    }

}
