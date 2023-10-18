package com.sisu.sisu.controller;

import com.sisu.sisu.Service.ITiposEstadoCivilService;
import com.sisu.sisu.entitys.TiposEstadoCivil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstadoCivilController {

    @Autowired
    private ITiposEstadoCivilService tiposEstadoCivilService;

    @GetMapping("/formEstadoCivil")
    public String registroEstadoC(@Validated TiposEstadoCivil tiposEstadoCivil, Model model) {
        model.addAttribute("tiposEstadoCiviles", tiposEstadoCivilService.findAll());
        return "tipos-estado-civil/index";
    }

    @GetMapping("/guardarEstadoCivil")
    public String registrarEstadoC(@Validated TiposEstadoCivil tiposEstadoCivil, Model model) {
        model.addAttribute("tiposEstadoCivil", new TiposEstadoCivil());
        return "tipos-estado-civil/nuevo";
    }

    /* eliminar */

    @RequestMapping(value = "/eliminarEstadoC/{idTipoEstadoCivil}")
    public String eliminarEstadoC(@PathVariable("idTipoEstadoCivil") Integer idTipoEstadoCivil) {
        TiposEstadoCivil tiposEstadoCivil = tiposEstadoCivilService.findOne(idTipoEstadoCivil);
        tiposEstadoCivil.setEstado("X");
        tiposEstadoCivilService.save(tiposEstadoCivil);
        return "";

    }

    /* Editar */

    @RequestMapping(value = "/editarTipoEstadoCivil/{idTipoEstadoCivil}")
    public String editarEStadoC(@PathVariable("idTipoEstadoCivil") Integer idTipoEstadoCivil, Model model) {
        TiposEstadoCivil tiposEstadoCivil = tiposEstadoCivilService.findOne(idTipoEstadoCivil);
        model.addAttribute("tiposEstadoCivil", tiposEstadoCivil);
        return "formularios/formTipoEstadoCivil";
    }

    /* Lista */

    @GetMapping(value = "/ListaTipoEstadoCivil")
    public String listarTiposEstadoCivil(Model model) {
        model.addAttribute("tiposEstadoCivil", tiposEstadoCivilService.findAll());
        return "listas/listasTipoEstadoCivil";
    }
}
