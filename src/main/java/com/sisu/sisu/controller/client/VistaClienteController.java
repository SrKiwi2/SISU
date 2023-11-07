package com.sisu.sisu.controller.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VistaClienteController {
    
    @RequestMapping(value = "/loginS", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		
		System.out.println("11111111111111111111111111111111111111111111");
		return "index/loginS";
	}

	@RequestMapping(value = "/inicioCaja", method = RequestMethod.GET)
	public String homeCaja(Model model, HttpServletRequest request) {
		
		System.out.println("11111111111111111111111111111111111111111111");
		return "client/inicioCaja";
	}

    @RequestMapping(value = "/ficha", method = RequestMethod.GET)
	public String vistaFicha(Model model, HttpServletRequest request) {
		
		System.out.println("11111111111111111111111111111111111111111111");
		return "Client/vistaCliente";
	}
}
