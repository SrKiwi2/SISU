package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisu.sisu.Service.IGradoService;
import com.sisu.sisu.Service.ITipoRecetaService;
import com.sisu.sisu.entitys.GradoAcademico;
import com.sisu.sisu.entitys.TipoReceta;

@Controller
public class TipoRecetaController {

    @Autowired
    private ITipoRecetaService tipoRecetaService;

    @GetMapping(value = "/formReceta")
    public String registroReceta(@Validated TipoReceta tipoReceta, Model model) {

        model.addAttribute("receta", new TipoRecetaController());
        model.addAttribute("recetas", tipoRecetaService.findAll());

        return "formularios/formReceta";
    }

    /* GUARDAR */

    @PostMapping(value = "/guardarReceta")
    public String RegistrarReceta(@Validated TipoReceta tipoReceta) {
        
        tipoReceta.setEstado("A");
        tipoRecetaService.save(tipoReceta);
        return "redirect:/ListaReceta";
    }

    /* eliminar */

    @RequestMapping(value = "/eliminarReceta/{idTipoReceta}")
    public String eliminarReceta(@PathVariable("idTipoReceta") Long idTipoReceta) {
        TipoReceta tipoReceta = tipoRecetaService.findOne(idTipoReceta);
        tipoReceta.setEstado("X");
        tipoRecetaService.save(tipoReceta);
        return "redirect:/ListaReceta";

    }

//     /* Editar */

    @RequestMapping(value = "/editarReceta/{idTipoReceta}")
    public String editarReceta(@PathVariable("idTipoReceta") Long idTipoReceta, Model model) {
        TipoReceta tipoReceta = tipoRecetaService.findOne(idTipoReceta);
        model.addAttribute("receta", tipoReceta);
        return "formularios/ListaReceta";
    }


    @GetMapping(value = "/ListaReceta")
    public String listarReceta(Model model) {

        model.addAttribute("recetas", tipoRecetaService.findAll());

        return "listas/listaReceta";
    }

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosReceta")
    public String guardarCambiosReceta(@ModelAttribute TipoReceta tipoReceta) {
        tipoReceta.setEstado("A");
        tipoRecetaService.save(tipoReceta);
        return "redirect:/listaReceta";
    }


    /* Modificación Modal */
    @RequestMapping(value = "/receta/{idTipoReceta}")
    public String getContentRE(@PathVariable(value = "idTipoReceta") Long idTipoReceta, Model model, 
    HttpServletRequest request) {

        model.addAttribute("recetas", tipoRecetaService.findOne(idTipoReceta));

        return "contentRE :: contentRE";
    }

}
