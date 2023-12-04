package com.sisu.sisu.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.sisu.sisu.Dao.IAseguradoDao;
import com.sisu.sisu.Service.IAseguradoService;
import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.entitys.Asegurado;
import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.TiposEstadoCivil;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class FichaSisuController {

	@Autowired
	private IPersonaService personaService;

	@Autowired
	private IAseguradoService aseguradoService;

	@RequestMapping(value = "universitario", method = RequestMethod.GET)
	public String obtenerDatosUniversitario(HttpServletRequest request, Model model,
			@RequestParam("codigoUniversitario") String ru) {
		
		System.out.println("--------------------MOSTRANDO DATOS ADMINISTRATIVO------------------");
		System.out.println("EL RU DEL UNIVERSITARIO ES :" + ru);

		Map<String, Object> requests = new HashMap<String, Object>();
		
		try{

			requests.put("ru", ru);

			String url = "http://181.115.188.250:9993/v1/service/api/cee024514f4e4b1f970bfb2b6486b421";
			String key = "key 70c8b6fc339aa5e6312dd42edf0636558948bb6008f1a0f867885d5e60e26c57";
			
			HttpHeaders headers = new HttpHeaders();
			
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("x-api-key", key);
			
			HttpEntity<HashMap> req = new HttpEntity(requests, headers);
			RestTemplate restTemplate = new RestTemplate();
			
			ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, req, Map.class);
			
			if (resp.getBody().get("status").toString().equals("200")) {
				Map<String, Object> data = (Map) resp.getBody().get("data");
			
				model.addAttribute("nombreUniversitario", data.get("nombres").toString());
				model.addAttribute("ci", data.get("ci").toString());
				model.addAttribute("ru", data.get("ru").toString());
				model.addAttribute("apPaterno", data.get("apellido_paterno").toString());
				model.addAttribute("apMaterno", data.get("apellido_materno").toString());
				model.addAttribute("fechaNacimiento", data.get("fecha_nacimiento").toString());
				model.addAttribute("direccion", data.get("direccion").toString());
				model.addAttribute("correo", data.get("correo").toString());
				model.addAttribute("carrera", data.get("carrera").toString());
				model.addAttribute("celular", data.get("celular").toString());
				model.addAttribute("tipoSanguineo", data.get("tipo_sanguineo").toString());
				model.addAttribute("sexo", data.get("sexo").toString());
				model.addAttribute("estadoMatriculacion", data.get("estado_matriculacion").toString());
				System.out.println("EL NOMBRE DEL UNIVERSITARIO ES " + data.get("nombres").toString());
				// Otros atributos...
			
				model.addAttribute("personaUniversitaria", data);
			
				Persona newpersona = personaService.findByCi(data.get("ci").toString());

				if (newpersona == null) {
					
					newpersona = new Persona();
					newpersona.setEstado("RU");
	    			newpersona.setNombres(data.get("nombres").toString());
	    			newpersona.setApPaterno(data.get("apellido_paterno").toString());
	    			newpersona.setApMaterno(data.get("apellido_materno").toString());
	    			newpersona.setCi(data.get("ci").toString());
	    			newpersona.setDireccion(data.get("direccion").toString());
	    			newpersona.setCelular(Integer.parseInt(data.get("celular").toString()));
	    			newpersona.setSexo(data.get("sexo").toString());
	    			newpersona.setFecha_nac(LocalDate.parse(data.get("fecha_nacimiento").toString()));	 
					personaService.save(newpersona);

					System.out.println("/--------------------------------------------------------/");
					System.out.println("¡guardo! UNIVERISTARIO registrado en la tabla persona  ¡guardo!");
					System.out.println("/--------------------------------------------------------/");

					// return "Client/vistaDatosUniversitario";
				}else{
					System.out.println("Helloooo");
					return "Client/vistaDatosUniversitario";
				}
				
				Asegurado codigoAseguradoExiste = aseguradoService.findAseguradoByPersonaId(newpersona.getIdPersona());
				if (codigoAseguradoExiste == null) {
					
					String codigoAsegurado = generateCodigoAsegurado(newpersona);
				
					Asegurado asegurado = new Asegurado();
					asegurado.setCodigoAsegurado(codigoAsegurado);
					asegurado.setPersona(newpersona);
					asegurado.setEstado("A");
					aseguradoService.save(asegurado);

					System.out.println("/------------------------------------------------/");
					System.out.println("SE GENERO EL CODIGO ASEGURADO PARA: "+newpersona.getNombres());
					System.out.println("/------------------------------------------------/");
					
					return "Client/vistaDatosUniversitario";
				}

				// else{
				// 	System.out.println("/------------------------------------------------/");
				// 	System.out.println("EL pibe ya tiene CODIGOASEGURADO!!!!11");
				// 	System.out.println("/------------------------------------------------/");
				// 	return "Client/inicioCliente";
				// }

				return "Client/inicioCliente";
			}
			return "Client/inicioCliente";

		} catch (Exception e) {
			e.printStackTrace();
			String msn = "Error: Revise su usuario y contraseña ";
			model.addAttribute("msn", msn);
			System.out.println("hola-------------------------------------");

			return "index/index";
		}
	}

	private String generateCodigoAsegurado(Persona persona) {
		String nombre = persona.getNombres();
		String apPaterno = persona.getApPaterno();
		String apMaterno = persona.getApMaterno();
		String ci = persona.getCi();
	
		// Obtener la primera letra de cada palabra y el CI
		String codigoAsegurado = String.valueOf(nombre.charAt(0)) +
								String.valueOf(apPaterno.charAt(0)) +
								String.valueOf(apMaterno.charAt(0)) +
								ci;
	
		return codigoAsegurado;
	}

	/* ----------------------------------------------------------------------------------------- */

	@RequestMapping(value = "docente", method = RequestMethod.GET)
	public String docente(HttpServletRequest request, Model model, 
				@RequestParam("codigoDocente") String rd) {

		Map<String, Object> request1 = new HashMap<>();

		try{
			System.out.println("el codigo docente es" + rd);

			request1.put("rd", rd);

			String url = "http://181.115.188.250:9993/v1/service/api/ae7ce0054d4c4f38a4a92bf1c0422b55";
			String key = "key 70c8b6fc339aa5e6312dd42edf0636558948bb6008f1a0f867885d5e60e26c57";

			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("x-api-key", key);

			HttpEntity<Map<String, Object>> req = new HttpEntity<>(request1, headers);
			RestTemplate restTemplate= new RestTemplate();

			ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, req, Map.class);
			System.out.println("---------------" + resp.getBody().get("status").toString() + "--------------------------");

			if (resp.getBody().get("status").toString().equals("200")) {
				System.out.println("----------------------------------SS--------");

				Map<String, Object> data = (Map) resp.getBody().get("data");

				System.out.println("------------RD: " + rd + "---------");
				System.out.println("------------------------------------------");
				System.out.println("EL NOMBRE DEL DOCENTE ES " + data.get("nombres").toString());
				System.out.println("-----------------DOCENTE------------------");

				String DatosDocente = data.get("nombres").toString();

				model.addAttribute("DatosDocente", DatosDocente);

				model.addAttribute("apellidoPaterno", data.get("apellido_paterno").toString());
				model.addAttribute("apellidoMaterno", data.get("apellido_materno").toString());
				model.addAttribute("ci", data.get("ci").toString());
				model.addAttribute("fechaNacimiento", data.get("fecha_nacimiento").toString());
				model.addAttribute("titulo", data.get("titulo").toString());
				model.addAttribute("gradoAcademico", data.get("grado_academico").toString());
				model.addAttribute("rd", data.get("rd").toString());
				model.addAttribute("tipoSanguineoD", data.get("tipo_sanguineo").toString());
				model.addAttribute("sexoD", data.get("sexo").toString());
				model.addAttribute("celularD", data.get("celular").toString());
				model.addAttribute("direccionD", data.get("direccion").toString());
				model.addAttribute("activo", data.get("activo").toString());
				System.out.println("---------------------------------------------------------------------------");
				System.out.println("EL NOMBRE DEL DOCENTE ES: "+data.get("nombres").toString());
				System.out.println("---------------------------------------------------------------------------");

				Persona existePersonaD = personaService.findByCi(data.get("ci").toString());

				if (existePersonaD == null) {

					System.out.println("--------------------------------------------------------");
					System.out.println("PREGUNTO PREGUNTO DOCENTE");
					System.out.println("--------------------------------------------------------");				
				
					existePersonaD = new Persona();
					existePersonaD.setEstado("RD");
					existePersonaD.setNombres(data.get("nombres").toString());
					existePersonaD.setApPaterno(data.get("apellido_paterno").toString());
	    			existePersonaD.setApMaterno(data.get("apellido_materno").toString());
	    			existePersonaD.setCi(data.get("ci").toString());
	    			existePersonaD.setDireccion(data.get("direccion").toString());
	    			existePersonaD.setCelular(Integer.parseInt(data.get("celular").toString()));
	    			existePersonaD.setSexo(data.get("sexo").toString());
	    			existePersonaD.setFecha_nac(LocalDate.parse(data.get("fecha_nacimiento").toString()));		
					personaService.save(existePersonaD);

					System.out.println("/--------------------------------------------------------/");
					System.out.println("¡guardo! DOCENTE registrado en la tabla persona ¡guardo!");
					System.out.println("/--------------------------------------------------------/");

				}else{
					return "Client/vistaDatosDocente";
				}

				Asegurado codigoAseguradoDExiste = aseguradoService.findAseguradoByPersonaId(existePersonaD.getIdPersona());

				if (codigoAseguradoDExiste == null) {

					String codigoAsegurado = generateCodigoAsegurado(existePersonaD);

					Asegurado aseguradoD = new Asegurado();
					aseguradoD.setCodigoAsegurado(codigoAsegurado);
					aseguradoD.setPersona(existePersonaD);
					aseguradoD.setEstado("A");
					aseguradoService.save(aseguradoD);

					System.out.println("/------------------------------------------------/");
					System.out.println("SE GENERO EL CODIGO ASEGURADO PARA: "+existePersonaD.getNombres());
					System.out.println("/------------------------------------------------/");
					
					return "Client/vistaDatosDocente";
				}
			}

			return "Client/vistaDatosDocente";
		} catch (Exception e){
			e.printStackTrace();
			String msn = "Error: Revise su usuario y contraseña ";
			model.addAttribute("msn", msn);
			System.out.println("hola-------------------------------------");

			return "index/index";
		}
	}


/* -------------------------------------------------------------------------------------------- */

	@RequestMapping(value = "/administrativo", method = RequestMethod.GET)
	public String administrativo(HttpServletRequest request, Model model,
			@RequestParam("codigoAdministrativo") String codigoAdministrativo) {
		Map<String, Object> request1 = new HashMap<>();
		try {
			request1.put("usuario", codigoAdministrativo);

			String url = "https://digital.uap.edu.bo/api/londra/api/londraPost/v1/personaLondra/obtenerDatos";

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Map<String, Object>> req = new HttpEntity<>(request1, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, req, Map.class);

			System.out.println("7777777777777777777777777777777777777+2");

			if (resp.getBody().get("status").toString().equals("200")) {
				System.out.println("hola-------------------------------------kiwi1");
				Map<String, Object> data = (Map) resp.getBody();
				System.out.println("hola-------------------------------------kiwi2");

				model.addAttribute("nombres", data.get("per_nombres").toString());
				model.addAttribute("apPaterno", data.get("per_ap_paterno").toString());
				model.addAttribute("apMaterno", data.get("per_ap_materno").toString());
				model.addAttribute("CA", data.get("per_id").toString());
				model.addAttribute("ci", data.get("per_num_doc").toString());
				model.addAttribute("fechaNacimientoA", data.get("fecha_nac").toString());
				model.addAttribute("sexoA", data.get("per_sexo").toString());
				model.addAttribute("gmailA", data.get("perd_email_personal").toString());
				model.addAttribute("descripcionA", data.get("p_descripcion").toString());
				model.addAttribute("descripcionA2", data.get("cp_descripcion").toString());
				model.addAttribute("nivel", data.get("nivelInstruccion").toString());

				Persona existPersonaA = personaService.findByCi(data.get("per_num_doc").toString());

				if (existPersonaA == null) {

					System.out.println("--------------------------------------------------------");
					System.out.println("PREGUNTO PREGUNTO ADMINISTRATIVO");
					System.out.println("--------------------------------------------------------");

					existPersonaA = new Persona();
					existPersonaA.setEstado("RA");
					existPersonaA.setNombres(data.get("per_nombres").toString());
					existPersonaA.setApPaterno(data.get("per_ap_paterno").toString());
					existPersonaA.setApMaterno(data.get("per_ap_materno").toString());
					existPersonaA.setCi(data.get("per_num_doc").toString());
					existPersonaA.setSexo(data.get("per_sexo").toString());
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate fechaNacimiento = LocalDate.parse(data.get("fecha_nac").toString(), formatter);
					existPersonaA.setFecha_nac(fechaNacimiento);
					personaService.save(existPersonaA);

					System.out.println("/--------------------------------------------------------/");
					System.out.println("PERSONA ADMINISTRATIVA GUARDADA");
					System.out.println("/--------------------------------------------------------/");

				}else{
					return "Client/vistaDatosAdministrativo";
				}

				Asegurado codigoAseguradoAExiste = aseguradoService.findAseguradoByPersonaId(existPersonaA.getIdPersona());
				if (codigoAseguradoAExiste == null) {

					String codigoAsegurado = generateCodigoAsegurado(existPersonaA);
				
					Asegurado aseguradoA = new Asegurado();
					aseguradoA.setCodigoAsegurado(codigoAsegurado);
					aseguradoA.setPersona(existPersonaA);
					aseguradoA.setEstado("A");
					aseguradoService.save(aseguradoA);

					System.out.println("/------------------------------------------------/");
					System.out.println("SE GENERO EL CODIGO ASEGURADO PARA: "+existPersonaA.getNombres());
					System.out.println("/------------------------------------------------/");
					
					return "Client/vistaDatosAdministrativo";
				}

			}
			System.out.println("hola-------------------------------------kiwi3");
			return "Client/vistaDatosAdministrativo";
		} catch (Exception e) {
			e.printStackTrace();
			String msn = "Error: Revise su usuario y contraseña ";
			model.addAttribute("msn", msn);
			System.out.println("hola-------------------------------------");

			return "index/index";
		}
	}

	@RequestMapping(value = "particular", method = RequestMethod.GET)
	public String particular(HttpServletRequest request, Model model) {
		System.out.print("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAA++PARTICULAR");
		return "index/index";
	}

}