package com.sisu.sisu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.sisu.sisu.Service.IPersonaService;

@Controller
public class FichasisuController {
	
	
	
	@Autowired
	private IPersonaService personaService;


	@RequestMapping(value = "universitario", method = RequestMethod.GET)
	public String universitario(HttpServletRequest request,Model model,
	@RequestParam("codigoUniversitario") String ru) {
		
		System.out.println("EL RU DEL UNIVERSITARIO ES :"+ru);
		
		System.out.println("-----------------ESTUDIANTE------------------");
		System.out.println("EL RU DEL UNIVERSITARIO ES :"+ru);
		System.out.println("------------RU: "+ru+"------");
		System.out.println("EL RU DEL UNIVERSITARIO ES :"+ru);
		System.out.println("---------------------------------------------");
		
		Map<String, Object> requests = new HashMap<String, Object>();
		
		requests.put("ru",ru);
		
		String url = "http://181.115.188.250:9993/v1/service/api/cee024514f4e4b1f970bfb2b6486b421";
		String key = "key 70c8b6fc339aa5e6312dd42edf0636558948bb6008f1a0f867885d5e60e26c57";
		
		HttpHeaders headers=new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-api-key", key);
		
		
		HttpEntity<HashMap> req = new HttpEntity(requests, headers);
		RestTemplate restTemplate=new RestTemplate();		
		
		ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, req, Map.class);
		
            if (resp.getBody().get("status").toString().equals("200")) {
				
            	Map<String, Object> data = (Map) resp.getBody().get("data");
            	
            	System.out.println("EL NOMBRE DEL UNIVERSITARIO ES "+data.get("nombres").toString());
                System.out.println("EL NOMBRE DEL UNIVERSITARIO ES "+data.get("apellido_paterno").toString());
                System.out.println("EL NOMBRE DEL UNIVERSITARIO ES "+data.get("apellido_materno").toString());
                                
                

			}

		
		return "index/index";
	}
	
	@RequestMapping(value = "docente", method = RequestMethod.GET)
	public String docente(HttpServletRequest request,Model model,@RequestParam("rd") String rd) {
		
	Map<String, Object> request1 = new HashMap<String, Object>();
	
	System.out.println("el codigo docente es"+rd);
		
		request1.put("rd",rd);
		
		String url = "http://181.115.188.250:9993/v1/service/api/ae7ce0054d4c4f38a4a92bf1c0422b55";
		String key = "key 70c8b6fc339aa5e6312dd42edf0636558948bb6008f1a0f867885d5e60e26c57";
		
		HttpHeaders headers=new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-api-key", key);
		
		
		HttpEntity<HashMap> req = new HttpEntity(request1, headers);
		RestTemplate restTemplate=new RestTemplate();		
		
		ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, req, Map.class);
		System.out.println("---------------"+resp.getBody().get("status").toString()+"--------------------------");

            if (resp.getBody().get("status").toString().equals("200")) {
        		System.out.println("----------------------------------SS--------");

				
            	Map<String, Object> data = (Map) resp.getBody().get("data");
            	System.out.println("------------RD: "+rd+"---------");
        		System.out.println("------------------------------------------");
            	System.out.println("EL NOMBRE DEL DOCENTE ES "+data.get("nombres").toString());
            	System.out.println("-----------------DOCENTE------------------");
        		
			}

		
		return "index/index";
	}
	
	

	// @RequestMapping(value = "administrativo", method = RequestMethod.GET)
	// public String administrativo(HttpServletRequest request,Model model,@RequestParam("codigoAdministrativo") String codigoAdministrativo) {
		
	// 	try {
			
	// 		Map<String,Object> request1=new HashMap<String,Object>();
			
	// 		request1.put("usuario", codigoAdministrativo);
			
	// 		String url="https://digital.uap.edu.bo/api/londra/api/londraPost/v1/personaLondra/obtenerDatos";
			
			
	// 		 HttpHeaders headers=new HttpHeaders();
	// 		  headers.setContentType(MediaType.APPLICATION_JSON);
			  
			  
	// 		  HttpEntity<HashMap> req = new HttpEntity(request1, headers);
			  
	// 		  RestTemplate restTemplate = new RestTemplate();

	// 	   ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, req, Map.class);
			   
	// 		System.out.println("7777777777777777777777777777777777777+2");
			
	// 		if (resp.getBody().get("status").toString().equals("200")) {

	// 			Map<String, Object> data = (Map) resp.getBody();

	// 			String ci=data.get("per_num_doc").toString();
    //             String nombre=data.get("per_nombres").toString();
    //             String ap_paterno=data.get("per_ap_paterno").toString();
    //             String ap_materno=data.get("per_ap_materno").toString();
    //             String fecha_naci=data.get("fecha_nac").toString();
    //             String celular=data.get("perd_celular").toString();

    //             Persona persona = new Persona();
    //             persona.setNombres(data.get("per_nombres").toString());
    //             persona.setCi(data.get("per_num_doc").toString());
    //             persona.setApMaterno(data.get("per_ap_paterno").toString());
    //             persona.setApMaterno(data.get("per_ap_materno").toString());

    //             model.addAttribute("persona", persona);


	// 			System.out.println("-----------------ADMINISTRATIVO------------------");
	// 			System.out.println("-----------------------CA: "+codigoAdministrativo+"-----------------");
	// 			System.out.println("---------------------------CI: "+ci+"---------------");
    //             System.out.println("---------------------------"+nombre+"---------------");
    //             System.out.println("---------------------------"+fecha_naci+"---------------");
	// 		}


			
	// 		return "index/index";
	// 	} catch (Exception e) {
			
			
			
	// 		String msn = "Error: Revise su usuario y contraseña ";
	// 		model.addAttribute("msn", msn);
	// 		System.out.println("hola-------------------------------------");
	// 		return "index/index";
	// 	}
		
		
		
		
	
	// }



	
	

	// @RequestMapping(value = "particular", method = RequestMethod.GET)
	// public String particular(HttpServletRequest request,Model model) {
		
	// 	System.out.print("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAA++PARTICULAR");
		
	// 	return "index/index";
	// }
	
	
	
}
