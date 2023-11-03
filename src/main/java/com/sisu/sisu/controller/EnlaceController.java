package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "formEnlace")
    public String registroEnlace(@Validated Enlace enlace, Model model) {

        model.addAttribute("enlace", new Enlace());
        model.addAttribute("enlaces", enlaceService.findAll());

        // model.addAttribute("usuario", new Usuario());
        // model.addAttribute("usuarios", usuarioService.findAll());

        return "formularios/formEnlace";
    }

    /* GUARDAR */
    @PostMapping(value = "/guardarEnlace")
    public String RegistrarEnlace(@Validated Enlace enlace, RedirectAttributes flash, HttpServletRequest request) {
        Usuario usuario = new Usuario();
        long idUsuario = 1;
        usuario = usuarioService.buscarUsuarioPorId(idUsuario);
        if (usuario!=null) {
            System.out.println(usuario.getPersona().getNombres());
        }
        enlace.setEstado("A");
        // enlaceService.save(enlace);
        return "redirect:formEnlace";
    }

    /* ELIMINAR */

    // @RequestMapping(value = "/eliminarEnlace/{idEnlace}")
    // public String eliminarEnlace(@PathVariable("idEnlace") Long idEnlace) {
    // Enlace enlace = enlaceService.findOne(idEnlace);
    // enlace.setEstado("A");
    // enlaceService.save(enlace);
    // return "redirect:/ListarEnlace";
    // }

    /* modificar un registro con el modal */

    // @RequestMapping(value = "enlace/{idEnlace}")
    // public String getContent1(@PathVariable(value = "idEnlace") Long idEnlace,
    // Model model,
    // HttpServletRequest request) {
    // model.addAttribute("enlace", enlaceService.findOne(idEnlace));
    // return "content :: content1";
    // }

    /* EDITAR */
    // @RequestMapping(value = "/editarEnlace/{idEnlace}")
    // public String editarEnlaceR(@PathVariable("idEnlace") Long idEnlace, Model
    // model) {
    // Enlace enlace = enlaceService.findOne(idEnlace);
    // model.addAttribute("enlace", enlace);
    // return "formularios/formEnlace";
    // }
    // /* LISTAR */
    // @GetMapping(value = "/ListaEnlace")
    // public String listarEnlace(Model model){
    // model.addAttribute("enlace", enlaceService.findAll());
    // return "listas/listaEnlace";
    // }
}
