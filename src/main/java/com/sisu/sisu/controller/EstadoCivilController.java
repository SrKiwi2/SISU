package com.sisu.sisu.controller;

import com.sisu.sisu.Service.ITiposEstadoCivilService;
import com.sisu.sisu.entitys.TiposEstadoCivil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstadoCivilController {

    @Autowired
    private ITiposEstadoCivilService tiposEstadoCivilService;

    /* obtener */
    @GetMapping(value = "/formEstadoC")
    public String registroFormC(@Validated TiposEstadoCivil tiposEstadoCivil, Model model) {

        model.addAttribute("estadoCivil", new TiposEstadoCivil());
        model.addAttribute("estadosCiviles", tiposEstadoCivilService.findAll());

        return "formularios/formEst_Civil";
    }

    /* guardar */
    @PostMapping(value = "/guardarEstadoC")
    public String RegistrarEstadoc(@Validated TiposEstadoCivil tiposEstadoCivil) {
        tiposEstadoCivil.setEstado("A");
        tiposEstadoCivilService.save(tiposEstadoCivil);
        return "redirect:/formEstadoC";
    }

    /* editar */
    @RequestMapping(value = "/editarEdtadoC/{idTipoEstadoCivil}")
    public String editarEstadoC(@PathVariable("idTipoEstadoCivil") Long idTipoEstadoCivil, Model model) {
        TiposEstadoCivil tiposEstadoCivil = tiposEstadoCivilService.findOne(idTipoEstadoCivil);
        model.addAttribute("tiposEstadoCivil", tiposEstadoCivil);
        return "formularios/formEst_Civil";
    }

    /* Eliminar */

    @RequestMapping(value = "/eliminarEstadoC/{idTipoEstadoCivil}")
    public String eliminarEstadoC(@PathVariable("idTipoEstadoCivil") Long idTipoEstadoCivil) {
        TiposEstadoCivil tiposEstadoCivil = tiposEstadoCivilService.findOne(idTipoEstadoCivil);
        tiposEstadoCivil.setEstado("X");
        tiposEstadoCivilService.save(tiposEstadoCivil);
        return "redirect:/ListasEstadoC";

    }

    /* lista */
    @GetMapping(value = "/ListasEstadoC")
    public String listarEstadoC(Model model) {

        model.addAttribute("estadosCiviles", tiposEstadoCivilService.findAll());

        return "listas/listaEstadoCivil";
    }

}
