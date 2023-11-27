package com.sisu.sisu.controller.Ficha;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sisu.sisu.Service.AseguradoService;
import com.sisu.sisu.Service.FichaService;
import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.entitys.Asegurado;
import com.sisu.sisu.entitys.Ficha;
import com.sisu.sisu.entitys.Persona;

@Controller
public class AseguradController {

    @Autowired
    private FichaService fichaService;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private AseguradoService aseguradoService;

    @RequestMapping(value = "/vistaF", method = RequestMethod.GET)
	public String vistaFicha(Model model, HttpServletRequest request) {

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", personaService.findAll());

        model.addAttribute("asegurado", new Persona());
        model.addAttribute("asegurados", aseguradoService.findAll());

		return "Fichas";
	}

     //-------------------------------to list---------------------------------

     @GetMapping(value="/listaAsegurado")
    public String lisataAsegurado(Model model, @Validated Asegurado asegurado) {

        model.addAttribute("ficha", new Ficha());
        model.addAttribute("fichas", fichaService.findAll());

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", personaService.findAll());

        model.addAttribute("asegurado", new Persona());
        model.addAttribute("asegurados", aseguradoService.findAll());
       
        return "Fichas/listaFicha";
    
    }


    // @RequestMapping(value = "datosAsegurado/{idAsegurado}")
    //  public String editTipoUso(@PathVariable("idAsegurado")Integer idAsegurado, Model model){

    //     Asegurado asegurado = aseguradoService.obtenerIdAsegurado(idAsegurado);
    //     model.addAttribute("ObAsegurado", asegurado);

    //     System.out.println("id persona es: " + asegurado.getPersona().getNombres());
    //     System.out.println("i++++++++++++++++++++++++++++++++++++++: " + asegurado.getPersona().getNombres());


    //     //  TipoUso tipoUso = tipoUsoService.findOne(idTipoUso);
    //     //  model.addAttribute("tipoUso", tipoUso);
 
    //      return "Fichas/datosHistorial";
    //  }
}
