package com.sisu.sisu.controller.Liname;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.FarmaceuticaService;
import com.sisu.sisu.Service.LinameService;
import com.sisu.sisu.Service.TipoUsoService;
import com.sisu.sisu.entitys.FormaFarmaceutica;
import com.sisu.sisu.entitys.ListaLiname;
import com.sisu.sisu.entitys.TipoUso;


@Controller
public class LinameController {

    @Autowired
    private LinameService linameService;

    @Autowired
    private FarmaceuticaService farmaceuticaService;

    @Autowired
    private TipoUsoService tipoUsoService;

    @GetMapping(value = "/vista")
    public String vistaLiname(Model model) {

        model.addAttribute("liname", new ListaLiname());
        model.addAttribute("listaLiname", linameService.findAll());

        model.addAttribute("farmaceutica", new FormaFarmaceutica());
        model.addAttribute("farmaceuticas", farmaceuticaService.findAll());

        model.addAttribute("tipoUso", new TipoUso());
        model.addAttribute("tipoUsos", tipoUsoService.findAll()); 


       return "Liname";
    
    }

    @PostMapping(value = "/saveLiname") // Enviar datos de Registro a Lista
	public String guaradarLinam(@Validated ListaLiname liname, RedirectAttributes flash,HttpServletRequest request,
    @RequestParam(name="nombreFormaFarmaceutica",required = false)Long idFormaFarmaceutica,
    @RequestParam(name="nombreTipoUso",required = false)Long idTipoUso
    ) { 
        liname.setEstadoLiname("A");
        liname.setForma_farmaceutica(farmaceuticaService.findOne(idFormaFarmaceutica));
        liname.setTipo_uso(tipoUsoService.findOne(idTipoUso));

        linameService.save(liname);

		return "redirect:/listaLiname";
	}


}
