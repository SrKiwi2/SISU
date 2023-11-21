package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminControllers {


    @GetMapping("/admin")
    public String vista(Model model,HttpServletRequest request) {

    	System.out.println("GOLLLLLLLLLLLL++++1");
		if (request.getSession().getAttribute("usuario") == null) {
			
			System.out.println("GOLLLLLLLLLLLL++++2");	
		    return "index/login";
		    
		}
		System.out.println("GOLLLLLLLLLLLL++++3");
        return "index/inicio";
        
    }
    
}
