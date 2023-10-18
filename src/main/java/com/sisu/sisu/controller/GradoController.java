package com.sisu.sisu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisu.sisu.Service.IGradoService;
import com.sisu.sisu.entitys.GradoAcademico;
import com.sisu.sisu.entitys.Persona;

@Controller
public class GradoController {

    @Autowired
    private IGradoService gradoService;

    @GetMapping(value = "/formGrado")
    public String registroGrado(@Validated GradoAcademico gradoAcademico, Model model) {

        model.addAttribute("grado", new GradoAcademico());
        model.addAttribute("grados", gradoService.findAll());

        return "formularios/formGrado";
    }

    /* GUARDAR */

    @PostMapping(value = "/guardarGrado")
    public String RegistrarGrado(@Validated GradoAcademico gradoAcademico) {
        
        gradoAcademico.setEstado("A");
        gradoService.save(gradoAcademico);
        return "redirect:/formGrado";
    }

    /* eliminar */

    @RequestMapping(value = "/eliminarGrado/{id_grado}")
    public String eliminarGrado(@PathVariable("id_grado") Long id_grado) {
        GradoAcademico gradoAcademico = gradoService.findOne(id_grado);
        gradoAcademico.setEstado("X");
        gradoService.save(gradoAcademico);
        return "redirect:/ListaGrado";

    }

//     /* Editar */

    @RequestMapping(value = "/editarGrado/{id_grado}")
    public String editarGrado(@PathVariable("id_grado") Long id_grado, Model model) {
        GradoAcademico gradoAcademico = gradoService.findOne(id_grado);
        model.addAttribute("grado", gradoAcademico);
        return "formularios/formGrado";
    }


    @GetMapping(value = "/ListaGrado")
    public String listarGrado(Model model) {

        model.addAttribute("grados", gradoService.findAll());

        return "listas/listaGrado";
    }

}
