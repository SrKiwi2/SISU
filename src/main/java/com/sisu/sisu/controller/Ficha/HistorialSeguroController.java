package com.sisu.sisu.controller.Ficha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.sisu.sisu.Service.HistorialSeguroService;
import com.sisu.sisu.entitys.HistorialSeguro;

@Controller
public class HistorialSeguroController {

    @Autowired
    private HistorialSeguroService historialSeguroService;

    @GetMapping(value = "/vistaHistorialSeguro/{idAsegurado}")
    public String vistaHistorial(@PathVariable("idAsegurado") Integer idAsegurado, Model model) {
        HistorialSeguro historialSeguro = historialSeguroService.getHistorial_por_id_seguro(idAsegurado);

        model.addAttribute("historial_seguro", historialSeguroService.getHistorial_por_id_seguro(idAsegurado));

        System.out.println("NOMBRE: " + historialSeguro.getAsegurado().getPersona().getNombres());

        return "Fichas/historialSeguro";
    }

}
