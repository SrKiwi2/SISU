package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.IEnlaceService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Enlace;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class EnlaceController {

    @Autowired
    private IEnlaceService enlaceService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "formEnlace")
    public String registroEnlace(@Validated Enlace enlace, Model model) {

        model.addAttribute("enlace", new Enlace());
        model.addAttribute("enlaces", enlaceService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        return "formularios/formEnlace";
    }

    /* GUARDAR */
    @PostMapping(value = "/guardarEnlace")
    public String RegistrarEnlace(@Validated Enlace enlace, RedirectAttributes flash, HttpServletRequest request) {

        Usuario usuario = usuarioService.buscarUsuarioPorId(1);
        // Usuario usuario = usuarioService.buscarUsuarioPorId(1l);

        enlace.setId_usuario(usuario);
        // enlaceService.listaEnlacePadre();
        // System.out.println(enlaceService.listaEnlacePadre().size());
        // System.out.println("+++++++++++++++++");

        enlace.setEstado("A");
        System.out.println(enlace.getNombre_enlace());
        enlace.setTabla(1);
        enlace.setObs("0");
        enlaceService.save(enlace);
        return "redirect:formEnlace";
    }

    @GetMapping(value = "formEnlaceHijo")
    public String registroEnlaceHijo(@Validated Enlace enlace, Model model) {

        model.addAttribute("enlace", new Enlace());
        model.addAttribute("enlaces", enlaceService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("listaEnlace", enlaceService.listaEnlacePadre());
        System.out.println(enlaceService.listaEnlacePadre().size());
        System.out.println("+++++++++++++++++");

        return "formularios/formEnlaceHijo";
    }

    /* GUARDAR */
    @PostMapping(value = "/guardarEnlaceHijo")
    public String registroEnlaceHijo(@Validated Enlace enlace, @RequestParam(name = "idEnlace2") Integer idEnlace,
            RedirectAttributes flash, HttpServletRequest request) {
        System.out.println("+++++++++++++++++1  ");
        Usuario usuario = usuarioService.buscarUsuarioPorId(1);

        enlace.setId_usuario(usuario);

        enlace.setEstado("A");
        // enlace.setRuta(null);

        enlace.setTabla(idEnlace);
        // System.out.println(idEnlace);
        enlace.setObs("1");
        // System.out.println(enlace.getIdEnlace());

        System.out.println("EL NOMBRE DEL ENLACE ES: " + enlace.getEnlace());
        enlaceService.save(enlace);
        return "redirect:formEnlace";
    }

    /* modificar un registro con el modal 

    @RequestMapping(value = "enlace/{idEnlace}")
    public String getContent1(@PathVariable(value = "idEnlace") Integer idEnlace, Model model,
            HttpServletRequest request) {
        model.addAttribute("enlace", enlaceService.findOne(idEnlace));

        return "content :: content1";
    }*/

    /* EDITAR 
    @RequestMapping(value = "/editarEnlace/{idEnlace}")
    public String editarEnlaceR(@PathVariable("idEnlace") Integer idEnlace, Model model) {
        Enlace enlace = enlaceService.findOne(idEnlace);
        model.addAttribute("enlace", enlace);

        return "formularios/formEnlace";
    }

    /* LISTAR */
    @GetMapping(value = "/ListaEnlace")
    public String listarEnlace(Model model) {

        model.addAttribute("enlace", new Enlace());
        model.addAttribute("enlaces", enlaceService.findAll());

        System.out.println(enlaceService.findAll().size());
        model.addAttribute("listaEnlace", enlaceService.listaEnlacePadre());

        return "listas/listaEnlace";
    }
}
