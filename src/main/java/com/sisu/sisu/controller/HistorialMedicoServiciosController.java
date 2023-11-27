package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisu.sisu.Service.HistorialMedicoServiciosService;
import com.sisu.sisu.entitys.HistorialMedicoServicio;

@Controller
public class HistorialMedicoServiciosController {
    
    @Autowired
    private HistorialMedicoServiciosService historialMedicoServicioService;

    // @Autowired
    // private ConceptoServiciosService conceptoServiciosService;

    // @Autowired
    // private AseguradoService aseguradoService;



    /*--------------- eliminar -----------*/
   @RequestMapping(value = "/eliminarHistorialMedicoServicio/{id_historial_medico_servicio}")
    public String eliminarHistorialMedicoServicios(@PathVariable("id_historial_medico_servicio") Integer id_historial_medico_servicio) {

        HistorialMedicoServicio historialMedicoServicio = historialMedicoServicioService.findOne(id_historial_medico_servicio);
        historialMedicoServicio.setEstado("X");
        historialMedicoServicioService.save(historialMedicoServicio);

        return "redirect:/ListaHistorialMedicoServicio";
    }

        // Listar HM -------------------------
     @GetMapping(value = "/ListaHistorialMedicoServicio")
     public String listarHistorialMedicoServicios(Model model) {

       model.addAttribute("historialMedicoServicio", new HistorialMedicoServicio());
        model.addAttribute("historialMedicoServicios", historialMedicoServicioService.findAll());

    //    model.addAttribute("dip", new Dip());
    //     model.addAttribute("dips", dipService.findAll());

    //     model.addAttribute("grado", new GradoAcademico());
    //     model.addAttribute("grados", gradoService.findAll());


        return "listas/ListaHistorialMedicoServicio";
    }

 

       /* Modificación Modal */
    @RequestMapping(value = "/historialMedicoServicios/{idHistorialMedicoServicio}")
    public String getContentHistorialMedicoServicio(@PathVariable(value = "idHistorialMedicoServicio") Integer idhistorialMedicoServiciosServicios, Model model,
            HttpServletRequest request) {

        model.addAttribute("historialMedicoServicio", historialMedicoServicioService.findOne(idhistorialMedicoServiciosServicios));

        return "contentDip :: contentHistorialMedicoServicio";

    }
/* Registrar Model */
  @RequestMapping(value = "/registrarHistorialMedicoServicio")
    public String getRegistroHistorialMedicoServicio(Model model) {

        model.addAttribute("historialMedicoServicio", new HistorialMedicoServicio());
        model.addAttribute("historialMedicoServicios", historialMedicoServicioService.findAll());


        return "contentDip :: contentHistorialMedicoServicio";
    }


 /* Guardar Cambios */
    @PostMapping(value = "/guardarHistorialMedicoServicio")
    public String guardarHistorialMedico(@ModelAttribute HistorialMedicoServicio historialMedicoServicioServicio) {

        historialMedicoServicioServicio.setEstado("A");
        historialMedicoServicioService.save(historialMedicoServicioServicio);

        return "redirect:/ListaHistorialMedicoServicio";
    }


    

}
