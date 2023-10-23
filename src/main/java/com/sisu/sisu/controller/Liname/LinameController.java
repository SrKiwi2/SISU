package com.sisu.sisu.controller.Liname;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.FarmaceuticaService;
import com.sisu.sisu.Service.ListaLinameService;
import com.sisu.sisu.Service.TipoUsoService;
import com.sisu.sisu.entitys.FormaFarmaceutica;
import com.sisu.sisu.entitys.ListaLiname;
import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.TipoUso;
import com.sisu.sisu.entitys.Usuario;



@Controller
public class LinameController {

    @Autowired
    private ListaLinameService listaLinameService;

    @Autowired
    private FarmaceuticaService farmaceuticaService;

    @Autowired
    private TipoUsoService tipoUsoService;

    @GetMapping(value = "/vista")
    public String vistaLiname(Model model) {

        model.addAttribute("listLiname", new ListaLiname());
        model.addAttribute("listLinames", listaLinameService.findAll());

        model.addAttribute("farmaceutica", new FormaFarmaceutica());
        model.addAttribute("farmaceuticas", farmaceuticaService.findAll());

        model.addAttribute("tipoUso", new TipoUso());
        model.addAttribute("tipoUsos", tipoUsoService.findAll()); 


       return "Liname";
    
    }

    //-------------------------------save---------------------------------

    @PostMapping(value = "/saveLiname") // Enviar datos de Registro a Lista
	public String guaradarLinam(@Validated ListaLiname listLiname, RedirectAttributes flash,HttpServletRequest request,
    @RequestParam(name="farmaceutica",required = false)Long idFormaFarmaceutica,
    @RequestParam(name="tipoUso",required = false)Long idTipoUso
    ) { 
        listLiname.setEstadoLiname("A");
        listLiname.setForma_farmaceutica(farmaceuticaService.findOne(idFormaFarmaceutica));
        listLiname.setTipo_uso(tipoUsoService.findOne(idTipoUso));

        listaLinameService.save(listLiname);

		return "redirect:/l-Liname";
	}


    //-------------------------------to list---------------------------------

       @GetMapping(value="/l-Liname")
    public String listaLiname(Model model, @Validated ListaLiname listLiname) {

        model.addAttribute("listLiname", new ListaLiname());
        model.addAttribute("listLinames", listaLinameService.findAll());

        model.addAttribute("farmaceutica", new FormaFarmaceutica());
        model.addAttribute("farmaceuticas", farmaceuticaService.findAll());

        model.addAttribute("tipoUso", new TipoUso());
        model.addAttribute("tipoUsos", tipoUsoService.findAll()); 
       
        return "listas/ListaLiname";
    
    }


    //-------------------------------Delete---------------------------------
    @RequestMapping(value = "/eliminLiname/{idLiname}")
    public String eliminarLiname(@PathVariable("idLiname")Long idLiname){

        ListaLiname listLiname = listaLinameService.findOne(idLiname);
        listLiname.setEstadoLiname("X");
        listaLinameService.save(listLiname);

        return "redirect:/l-Liname";
    }

    //-------------------------------Edit---------------------------------
    @RequestMapping(value = "/editLiname/{idLiname}")
    public String editLiname(@PathVariable("idLiname")Long idLiname, Model model){

        ListaLiname listLiname = listaLinameService.findOne(idLiname);
        model.addAttribute("listLiname", listLiname);

        return "redirect:/l-Liname";
    }


    @RequestMapping(value = "/listLiname/{idLiname}")
    public String getContent1(@PathVariable(value = "idLiname") Long idLiname, Model model,
    HttpServletRequest request) {

        model.addAttribute("listLiname", listaLinameService.findOne(idLiname));
        model.addAttribute("farmaceuticas", farmaceuticaService.findAll());
        model.addAttribute("tipoUsos", tipoUsoService.findAll()); 

        return "content :: contentLiname";
    }


    @PostMapping(value = "/SaveLiname")
    public String guardarCambiosPersona(@ModelAttribute ListaLiname listLiname,
     @RequestParam(name="farmaceutica",required = false)Long idFormaFarmaceutica,
    @RequestParam(name="tipoUso",required = false)Long idTipoUso
    ) {

        listLiname.setEstadoLiname("A");
        listLiname.setForma_farmaceutica(farmaceuticaService.findOne(idFormaFarmaceutica));
        listLiname.setTipo_uso(tipoUsoService.findOne(idTipoUso));
        listaLinameService.save(listLiname);
       
        return "redirect:/l-Liname";
    }


}