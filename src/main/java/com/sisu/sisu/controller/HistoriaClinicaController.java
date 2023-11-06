package com.sisu.sisu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sisu.sisu.Service.HistoriaClinicaService;
import com.sisu.sisu.entitys.HistoriaClinica;

@Controller
public class HistoriaClinicaController {

    @Autowired
    HistoriaClinicaService historiaClinicaService;

      @GetMapping(value = "/formHistorialClinico")
    public String registroRoles(@Validated HistoriaClinica historiaClinica, Model model) {
        
        model.addAttribute("historiaClinica", new HistoriaClinica());
        model.addAttribute("historiaClinicas", historiaClinicaService.findAll());

        return "formularios/FormHistoriaClinica";
    }


    @PostMapping(value = "/guardarHistorialClinico")
    public String RegistroRol(@Validated HistoriaClinica historiaClinica){
        
        try {
        historiaClinica.setEstadoHistoriaClinica("A");;
        historiaClinicaService.save(historiaClinica);
    
        } catch (Exception e) {
            
            return "redirect:/formHistorialClinico";
        }

        return "redirect:/formHistorialClinico";
    }


    
}
