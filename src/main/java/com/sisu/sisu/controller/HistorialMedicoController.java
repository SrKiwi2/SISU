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

import com.sisu.sisu.Service.ConceptosServiciosService;
import com.sisu.sisu.Service.HistorialMedicoService;
import com.sisu.sisu.entitys.HistorialMedico;
import com.sisu.sisu.entitys.ConceptosServicios;

@Controller
public class HistorialMedicoController {
    
    @Autowired
    private HistorialMedicoService historialMedicoService;

    @Autowired
    private ConceptosServiciosService conceptosServiciosService;

    // @Autowired
    // private AseguradoService aseguradoService;



    /*--------------- eliminar -----------*/
   @RequestMapping(value = "/eliminarHistorialMedico/{id_historial_medico}")
    public String eliminarHistorialMedico(@PathVariable("id_historial_medico") Integer id_historial_medico) {

        HistorialMedico historialMedico = historialMedicoService.findOne(id_historial_medico);
        historialMedico.setEstado("X");
        historialMedicoService.save(historialMedico);
        return "redirect:/ListaHistorialMedico";
    }

        // Listar HM -------------------------
     @GetMapping(value = "/ListaHistorialMedico")
     public String listarHistorialMedico(Model model) {

       model.addAttribute("historialMedico", new HistorialMedico());
        model.addAttribute("historialMedicos", historialMedicoService.findAll());

       model.addAttribute("conceptosServicio", new ConceptosServicios());
        model.addAttribute("conceptosServicios", conceptosServiciosService.findAll());

    //     model.addAttribute("grado", new GradoAcademico());
    //     model.addAttribute("grados", gradoService.findAll());
        

        return "listas/listaHistorialMedico";
    }

 

       /* Modificación Modal */
    @RequestMapping(value = "/historialMedico/{idHistorialMedico}")
    public String getContentHistorialMedico(@PathVariable(value = "idHistorialMedico") Integer idhistorialMedico, Model model,
            HttpServletRequest request) {

        model.addAttribute("historialMedico", historialMedicoService.findOne(idhistorialMedico));

        return "contentDip :: contentHistorialMedico";

    }
    
/* Registrar Model */
  @RequestMapping(value = "/registrarHistorialMedico")
    public String getRegistroHistorialMedico(Model model) {

        model.addAttribute("historialMedico", new HistorialMedico());
        model.addAttribute("historialMedicos", historialMedicoService.findAll());


        return "contentDip :: contentHistorialMedico";
    }


 /* Guardar Cambios */
    @PostMapping(value = "/guardarHistorialMedico")
    public String guardarHistorialMedico(@ModelAttribute HistorialMedico historialMedico) {

        historialMedico.setEstado("A");
        historialMedicoService.save(historialMedico);

        return "redirect:/ListaHistorialMedico";
    }


    

}
