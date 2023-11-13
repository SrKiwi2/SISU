package com.sisu.sisu.controller.menu;

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
import com.sisu.sisu.Service.IMenuService;
import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Enlace;
import com.sisu.sisu.entitys.Menu;
import com.sisu.sisu.entitys.Roles;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IEnlaceService enlaceService;

    @Autowired
    private IRolesService rolesService;

    @Autowired
    private UsuarioService usuarioService;

    /* FORM MENU 1 */

    @GetMapping(value = "formMenu1")
    public String registroMenu(@Validated Menu menu, Model model) {

        model.addAttribute("menu", new Menu());
        model.addAttribute("menus", menuService.findAll());

        model.addAttribute("enlace", new Enlace());
        model.addAttribute("enlaces", enlaceService.findAll());

        model.addAttribute("role", new Roles());
        model.addAttribute("roles", rolesService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        // model.addAttribute("listaEnlacesHijo",
        // enlaceService.listaEnlaceHijo(idEnlacePadre));

        return "listas/listaMenu";

    }

    @PostMapping(value = "/guardarMenu")
    public String guardarMenu(@Validated Menu menu) {
        menu.setIdEstado("A");
        menuService.save(menu);

        return "redirect:/formMenu1";
    }

    @GetMapping(value = "/listaMenu")
    public String listaMenu(Model model, @RequestParam("idEnlacePadre") Integer idEnlacePadre) {

        model.addAttribute("menu", new Enlace());
        model.addAttribute("menus", menuService.findAll());

        model.addAttribute("role", new Roles());
        model.addAttribute("roles", rolesService.findAll());

        // model.addAttribute("listaEnlacesHijo",
        // enlaceService.listaEnlaceHijo(idEnlacePadre));

        return "listas/listaMenu";
    }
    /* FORM MENU 2 */

    // /* registrar con el modal */
    // @RequestMapping(value = "/registrarMenu")
    // public String getRegistroMenu(Model model) {
    // model.addAttribute("menu", new Menu());
    // model.addAttribute("menus", menuService.findAll());

    // return "contentRE :: contentTipoReceta";
    // }

}
