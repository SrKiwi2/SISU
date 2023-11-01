package com.sisu.sisu.controller;

import com.sisu.sisu.Service.ITiposEstadoCivilService;
import com.sisu.sisu.entitys.TiposEstadoCivil;
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

@Controller
public class EstadoCivilController {

    @Autowired
    private ITiposEstadoCivilService tiposEstadoCivilService;

    /* formulario */

    @GetMapping(value = "/formRegistroEstadoC")
    public String registroPersona(@Validated TiposEstadoCivil tiposEstadoCivil, Model model) {

        model.addAttribute("estadoCivil", new TiposEstadoCivil());
        model.addAttribute("estadosCiviles", tiposEstadoCivilService.findAll());

        return "formularios/formEst_Civil";
    }

    @PostMapping(value = "/guardarEstadoCivil")
    public String guardaEstadoCivil(@Validated TiposEstadoCivil tiposEstadoCivil) {
        tiposEstadoCivil.setEstado("A");
        tiposEstadoCivilService.save(tiposEstadoCivil);
        return "redirect:/formRegistroEstadoC";
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

    /* registrar con el modal */
    @RequestMapping(value = "/registrarEstadoCivil")
    public String getRegistroEstadoC(Model model) {
        model.addAttribute("estadoCivil", new TiposEstadoCivil());
        model.addAttribute("estadosCiviles", tiposEstadoCivilService.findAll());
        return "contentRE :: contentEstadoReceta";
    }

    /* modificar con el mnodal */
    @RequestMapping(value = "/estadoCivill/{idTipoEstadoCivil}")
    public String getEstadoCivill(@PathVariable(value = "idTipoEstadoCivil") Long idTipoEstadoCivil, Model model,
            HttpServletRequest request) {
        model.addAttribute("estadoCivil", tiposEstadoCivilService.findOne(idTipoEstadoCivil));
        return "contentRE :: contentEstadoReceta";
    }

    @PostMapping(value = "/guardarCambiosEstadoC")
    public String guardaCambiosEstadoC(@ModelAttribute TiposEstadoCivil tiposEstadoCivil) {
        tiposEstadoCivil.setEstado("A");
        tiposEstadoCivilService.save(tiposEstadoCivil);
        return "redirect:/ListasEstadoC";
    }

}
