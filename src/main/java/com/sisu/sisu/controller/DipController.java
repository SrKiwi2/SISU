package com.sisu.sisu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisu.sisu.Service.IDipService;
import com.sisu.sisu.entitys.Dip;


@Controller
public class DipController {

    @Autowired
    private IDipService iDipService;

    //----------- Formulario para registrar --------

        @GetMapping(value = "/formRegistroDip")
    public String registroDip(@Validated Dip dip, Model model){
        
        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", iDipService.findAll());

        return "formularios/formDip";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarDip")
    public String RegistrarDip(@Validated Dip dip){
        dip.setEstado("A");
        iDipService.save(dip);
        return "redirect:/formRegistroDip";
    }

    //--------------------------------------------


   /*--------------- eliminar -----------*/
    
    @RequestMapping(value = "/eliminarDip/{id_dip}")
    public String eliminarDip(@PathVariable("id_dip")Long id_dip){
        Dip dip = iDipService.findOne(id_dip);
        dip.setEstado("X");
        iDipService.save(dip);
        return "redirect:/ListasDip";
        
    }

     //--------------------------------------------


    /* -------------------Editar -------------------*/

    @RequestMapping(value = "/editarDip/{id_dip}")
    public String editarDip(@PathVariable("id_dip")Long id_dip, Model model){
        Dip dip = iDipService.findOne(id_dip);
        model.addAttribute("dip", dip);
        return "formularios/formDip";
    }

     //--------------------------------------------


    /* ------------ Lista ----------------- */
    
    @GetMapping(value = "/ListasDip")
    public String listarDip (Model model){

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", iDipService.findAll());
        

        return "listas/listaDip";
    }

     //--------------------------------------------


}
