package com.sisu.sisu.controller.Liname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sisu.sisu.Service.HistoriaLinameService;

@Controller
public class HistorialLinameController {

    @Autowired
    private HistoriaLinameService historialService;
    

    @GetMapping(value = "vistaHistorial")
    public String historialVista(Model model) {

    

        return "historial";
    }
}
