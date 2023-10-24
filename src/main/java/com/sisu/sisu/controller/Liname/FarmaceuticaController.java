package com.sisu.sisu.controller.Liname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisu.sisu.Service.FarmaceuticaService;
import com.sisu.sisu.entitys.FormaFarmaceutica;

@Controller
public class FarmaceuticaController {

    @Autowired
    private FarmaceuticaService FormaFarmaceuticaService;

    @GetMapping(value = "vistaFarmaceutica")
    public String historialVista(Model model) {

      model.addAttribute("farmaceutica", new FormaFarmaceutica());
      model.addAttribute("farmaceuticas", FormaFarmaceuticaService.findAll());

        return "farmace";
    }

    //-------------------------------save---------------------------------

    @PostMapping(value = "/saveformaFarma") // Enviar datos de Registro a Lista
	public String guaradarFFarmaceutica(@Validated FormaFarmaceutica formaFarmaceutica) { 

        formaFarmaceutica.setEstadoFF("A");
        FormaFarmaceuticaService.save(formaFarmaceutica);

		return "redirect:/l-FormaFarma";
	}

    //-------------------------------to list---------------------------------

       @GetMapping(value="/l-Farmaceutica")
    public String listaTipoUso(Model model, @Validated FormaFarmaceutica formaFarmaceutica) {

        model.addAttribute("farmaceutica", new FormaFarmaceutica());
        model.addAttribute("farmaceuticas", FormaFarmaceuticaService.findAll());
       
        return "listas/Liname/ListaFormFarma";
    
    }

    //-------------------------------Delete---------------------------------
    @RequestMapping(value = "/eliminFarma/{idFormaFarmaceutica}")
    public String eliminarFFarmaceutica(@PathVariable("idFormaFarmaceutica")Long idFormaFarmaceutica){

        FormaFarmaceutica formaFarmaceutica = FormaFarmaceuticaService.findOne(idFormaFarmaceutica);
        formaFarmaceutica.setEstadoFF("X");
        FormaFarmaceuticaService.save(formaFarmaceutica);

        return "redirect:/l-Farmaceutica";
    }

    
}
