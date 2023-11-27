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
import com.sisu.sisu.entitys.ConceptosServicios;

@Controller
public class ConceptosServiciosController {
    
    @Autowired
    private ConceptosServiciosService conceptosServiciosService;

    // @Autowired
    // private ConceptoServiciosService conceptoServiciosService;

    // @Autowired
    // private AseguradoService aseguradoService;



    /*--------------- eliminar -----------*/
   @RequestMapping(value = "/eliminarConceptosServicios/{id_concepto_servicio}")
    public String eliminarconceptosServicios(@PathVariable("id_concepto_servicio") Integer id_historial_medico) {

        ConceptosServicios conceptosServicios = conceptosServiciosService.findOne(id_historial_medico);
        conceptosServicios.setEstado("X");
        conceptosServiciosService.save(conceptosServicios);
        return "redirect:/ListaConceptosServicios";
    }

        // Listar HM -------------------------
     @GetMapping(value = "/ListaConceptosServicios")
     public String listarconceptosServicios(Model model) {

       model.addAttribute("conceptosServicio", new ConceptosServicios());
        model.addAttribute("conceptosServicios", conceptosServiciosService.findAll());

    //    model.addAttribute("dip", new Dip());
    //     model.addAttribute("dips", dipService.findAll());

    //     model.addAttribute("grado", new GradoAcademico());
    //     model.addAttribute("grados", gradoService.findAll());

        return "listas/listaConceptosServicios";
    } 
    
       /* Modificación Modal */
    @RequestMapping(value = "/conceptosServicios/{idConceptoServicio}")
    public String getContentConceptosServicios(@PathVariable(value = "idConceptoServicio") Integer idconceptoServicio, Model model, HttpServletRequest request) {

        model.addAttribute("conceptosServicio", conceptosServiciosService.findOne(idconceptoServicio));

        return "contentDip :: contentConceptosServicios";
    }
    
/* Registrar Model */
  @RequestMapping(value = "/registrarConceptosServicios")
    public String getRegistroConceptosServicios(Model model) {

        model.addAttribute("conceptosServicio", new ConceptosServicios());
        model.addAttribute("ConceptosServicios", conceptosServiciosService.findAll());


        return "contentDip :: contentConceptosServicios";
    }


 /* Guardar Cambios */
    @PostMapping(value = "/guardarConceptosServicios")
    public String guardarConceptosServicios(@ModelAttribute ConceptosServicios conceptosServicios) {

        conceptosServicios.setEstado("A");
        conceptosServiciosService.save(conceptosServicios);

        return "redirect:/ListaConceptosServicios";
    }

}
