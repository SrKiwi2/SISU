package com.sisu.sisu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisu.sisu.Service.IGradoService;
import com.sisu.sisu.Service.ITipoRecetaService;
import com.sisu.sisu.entitys.TipoReceta;

@Controller
public class TipoRecetaController {

    @Autowired
    private ITipoRecetaService tipoRecetaService;

    @GetMapping(value = "/formReceta")
    public String registroReceta(Model model) {

       model.addAttribute("tipoReceta", new TipoReceta());
       model.addAttribute("tipoRecetas", tipoRecetaService.findAll());
    

        return "";
    }

    /* GUARDAR */

    @PostMapping(value = "/guardarReceta")
    public String RegistrarReceta(@Validated TipoReceta tipoReceta) {
        
        tipoReceta.setEstado("A");
        tipoRecetaService.save(tipoReceta);

        return "redirect:/ListaReceta";
    }

    /* eliminar */

    // @RequestMapping(value = "/eliminarReceta/{id_receta}")
    // public String eliminarReceta(@PathVariable("id_receta") Long id_receta) {
    //     TipoReceta tipoReceta = tipoRecetaService.findOne(id_receta);
    //     tipoReceta.setEstado("X");
    //     tipoRecetaService.save(tipoReceta);
    //     return "redirect:/ListaReceta";

    // }

//     /* Editar */

    // @RequestMapping(value = "/editarReceta/{id_receta}")
    // public String editarReceta(@PathVariable("id_receta") Long id_receta, Model model) {
    //     TipoReceta tipoReceta = tipoRecetaService.findOne(id_receta);
    //     model.addAttribute("receta", tipoReceta);
    //     return "formularios/ListaReceta";
    // }


    @GetMapping(value = "/ListaReceta")
    public String listarReceta(@Validated TipoReceta tipoReceta, Model model) {

        model.addAttribute("recetas", tipoRecetaService.findAll());

        return "listas/listaTipoReceta";
    }

    /* Guardar Cambios */
    // @PostMapping(value = "/guardarCambiosReceta")
    // public String guardarCambiosReceta(@ModelAttribute TipoReceta tipoReceta) {
    //     tipoReceta.setEstado("A");
    //     tipoRecetaService.save(tipoReceta);
    //     return "redirect:/ListaReceta";
    // }


    /* Modificación Modal */
    // @RequestMapping(value = "/receta/{idTipoReceta}")
    // public String getContentRE(@PathVariable(value = "idTipoReceta") Long idTipoReceta, Model model, 
    // HttpServletRequest request) {

    //     model.addAttribute("recetas", tipoRecetaService.findOne(idTipoReceta));

    //     return "contentRE :: contentRE";
    // }

}
