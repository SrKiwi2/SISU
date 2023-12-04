package com.sisu.sisu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisu.sisu.Service.FichaService;
import com.sisu.sisu.Service.HistoriaClinicaService;
import com.sisu.sisu.Service.HistorialSeguroService;
import com.sisu.sisu.entitys.HistoriaClinica;
import com.sisu.sisu.entitys.HistorialSeguro;

@Controller
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @Autowired
    private HistorialSeguroService historialSeguroService;

    @GetMapping(value = "/formHistorialClinico/{id}")
    public String registroRoles(@Validated HistoriaClinica historiaClinica,@PathVariable(name = "id")Integer id, Model model) {

        HistorialSeguro historialSeguro = historialSeguroService.findOne(id);

        model.addAttribute("historialSeguro", historialSeguro);
        // model.addAttribute("historiaClinica", new HistoriaClinica());
        model.addAttribute("historiaClinicas", historiaClinicaService.findAll());

        return "formularios/FormHistoriaClinica";
    }

    @PostMapping(value = "/guardarHistorialClinico")
    public String RegistroRol(@Validated HistoriaClinica historiaClinica) {

        try {
            historiaClinica.setEstadoHistoriaClinica("A");
            historiaClinicaService.save(historiaClinica);

        } catch (Exception e) {

            return "redirect:/formHistorialClinico";
        }
        System.out.println("++++++++++++++++++++++++++++++++++++");

        return "redirect:/fichaEstado";
    }

}
