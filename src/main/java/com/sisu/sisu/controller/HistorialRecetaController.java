package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisu.sisu.Service.HistorialRecetaService;
import com.sisu.sisu.entitys.HistorialReceta;

@Controller
public class HistorialRecetaController {

    @Autowired
    private HistorialRecetaService historialRecetapService; 

     /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarHistorialReceta/{id_historial_receta}")
    public String eliminarHistorialReceta(@PathVariable("id_historial_receta") Integer id_historial_receta) {

        HistorialReceta historialReceta = historialRecetapService.findOne(id_historial_receta);
        historialReceta.setEstado("X");
        historialRecetapService.save(historialReceta);
        return "redirect:/ListasHistorialReceta";

    }

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/ListasHistorialReceta")
    public String listarHistorialRecetas(Model model) {

        model.addAttribute("historialReceta", new HistorialReceta());
        model.addAttribute("HistorialRecetas", historialRecetapService.findAll());

        return "listas/listaHistorialReceta";
    } 

    /* Modificación Modal */
    @RequestMapping(value = "/historialReceta/{idHistorialReceta}")
    public String getContentHistorialRecetas(@PathVariable(value = "idHistorialReceta") Integer idDip, Model model,
            HttpServletRequest request) {

        model.addAttribute("historialReceta", historialRecetapService.findOne(idDip));

        return "contentDip :: contentHistorialRecetas";

    }

    /* Registrar DIP model */
    @RequestMapping(value = "/registrarHistorialRecetas")
    public String getRegistroHistorialRecetas(Model model) {

        model.addAttribute("historialReceta", new HistorialReceta());
        model.addAttribute("HistorialRecetas", historialRecetapService.findAll());
        return "contentDip :: contentHistorialRecetas";
    } 
    
    /* Guardar Cambios */
    @PostMapping(value = "/guardarHistorialRecetas")
    public String guardarHistorialRecetas(@ModelAttribute HistorialReceta historialReceta) {
        historialReceta.setEstado("A");
        historialRecetapService.save(historialReceta);
        return "redirect:/ListasHistorialReceta";
    } 
}
