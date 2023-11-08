package com.sisu.sisu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sisu.sisu.Service.UsrRolesService;
import com.sisu.sisu.entitys.UsrRoles;

@Controller
public class login {

	@Autowired
	UsrRolesService usrRolesService;

	@RequestMapping(value = "/InicioSesion", method = RequestMethod.GET)
	public String iniciosesion(Model model) {

		System.out.println("11111111111111111111111111111111111111111111");
		return "index/login";
	}

	@RequestMapping(value = "/Inicio", method = RequestMethod.GET)
	public String inicio(Model model) {

		System.out.println("11111111111111111111111111111111111111111111");
		return "index/index";
	}

	@RequestMapping(value = "/loginE", method = RequestMethod.POST)
	public String loginE(Model model) {

		System.out.println("11111111111111111111111111111111111111111111");
		return "index/index";
	}

	@RequestMapping(value = "/loginK", method = RequestMethod.GET)
	public String Ficha(Model model, HttpServletRequest request) {

		System.out.println("11111111111111111111111111111111111111111111");
		return "index/loginK";
	}

	@RequestMapping(value = "roles", method = RequestMethod.GET)
	public String roles(Model model, HttpServletRequest request) {

		UsrRoles usr = new UsrRoles();

		List<UsrRoles> listadeUsuarios = usrRolesService.listarRoles();

		System.out.println("hola");

		model.addAttribute("listadeUsuarios", listadeUsuarios);
		return "formularios/formulario";
	}

}
