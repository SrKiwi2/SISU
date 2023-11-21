package com.sisu.sisu.controller;

import java.time.LocalDate;
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

import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.TiposEstadoCivil;

@Controller
public class FichaSisuController {

	@Autowired
	private IPersonaService personaService;

	@RequestMapping(value = "universitario", method = RequestMethod.GET)
	public String universitario(HttpServletRequest request, Model model,
			@RequestParam("codigoUniversitario") String ru) {

		System.out.println("EL RU DEL UNIVERSITARIO ES :" + ru);
		System.out.println("-----------------ESTUDIANTE------------------");
		System.out.println("EL RU DEL UNIVERSITARIO ES :" + ru);
		System.out.println("------------RU: " + ru + "------");
		System.out.println("EL RU DEL UNIVERSITARIO ES :" + ru);
		System.out.println("---------------------------------------------");

		Map<String, Object> requests = new HashMap<String, Object>();

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
			String nombreUniversitario = data.get("nombres").toString();
			// String urlImagen = data.get("url_imagen").toString();

			model.addAttribute("nombreUniversitario", nombreUniversitario);
			// model.addAttribute("urlImagen", urlImagen);

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

			Persona persona = new Persona();
			persona.setNombres(data.get("nombres").toString());
			persona.setApPaterno(data.get("apellido_paterno").toString());
			persona.setApMaterno(data.get("apellido_materno").toString());
			persona.setCi(data.get("ci").toString());
			persona.setDireccion(data.get("direccion").toString());
			persona.setCelular(Integer.parseInt(data.get("celular").toString()));
			persona.setSexo(data.get("sexo").toString());
			persona.setFecha_nac(LocalDate.parse(data.get("fecha_nac").toString()));
			persona.setTipos_estado_civil(TiposEstadoCivil.parse(data.get("tipos_estado_civil").toString()));

			model.addAttribute("personaUniversitaria", persona);
			model.addAttribute("personasAdministrativos", personaService.findAll());
		}

		return "Client/vistaDatosCliente";
	}
	/* ------- GUARDAR COMO PERSONA ------- */
	@PostMapping(value = "/saveUniveristario")
	public String guardarAdmins(Model model, @ModelAttribute Persona persona) {
		try {

			persona.setEstado("RU");
			personaService.save(persona);
			return "redirect:/ticket";

		} catch (Exception e) {
			// Manejo de errores si ocurre alguna excepción al guardar la persona
			String mensajeError = "Error al guardar la persona: " + e.getMessage();
			model.addAttribute("mensajeError", mensajeError);

			return "error"; // Puedes redirigir a una página de error
		}
	}
	/* ------------------------------------ */




	@RequestMapping(value = "docente", method = RequestMethod.GET)
	public String docente(HttpServletRequest request, Model model, @RequestParam("rd") String rd) {

		Map<String, Object> request1 = new HashMap<String, Object>();

		System.out.println("el codigo docente es" + rd);

		request1.put("rd", rd);

		String url = "http://181.115.188.250:9993/v1/service/api/ae7ce0054d4c4f38a4a92bf1c0422b55";
		String key = "key 70c8b6fc339aa5e6312dd42edf0636558948bb6008f1a0f867885d5e60e26c57";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-api-key", key);

		HttpEntity<HashMap> req = new HttpEntity(request1, headers);
		RestTemplate restTemplate = new RestTemplate();

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

			model.addAttribute("apellidoPaterno", data.get("apellido_paterno")).toString();
			model.addAttribute("apellidoMaterno", data.get("apellido_materno")).toString();
			model.addAttribute("ci", data.get("ci").toString());
			model.addAttribute("fechaNacimiento", data.get("fecha_nacimiento")).toString();
			model.addAttribute("titulo", data.get("titulo").toString());
			model.addAttribute("gradoAcademico", data.get("grado_academico").toString());
			model.addAttribute("rd", data.get("rd").toString());
			model.addAttribute("tipoSanguineo", data.get("tipo_sanguineo")).toString();
			model.addAttribute("sexo", data.get("sexo")).toString();
			model.addAttribute("direccion", data.get("direccion")).toString();
			model.addAttribute("activo", data.get("activo")).toString();

		}

		return "index/DatosDocente";
	}

	// @RequestMapping(value = "administrativo", method = RequestMethod.GET)
	// public String administrativo(HttpServletRequest request,Model
	// model,@RequestParam("codigoAdministrativo") String codigoAdministrativo) {

	// try {

	// Map<String,Object> request1=new HashMap<String,Object>();

	// request1.put("usuario", codigoAdministrativo);

	// String
	// url="https://digital.uap.edu.bo/api/londra/api/londraPost/v1/personaLondra/obtenerDatos";

	// HttpHeaders headers=new HttpHeaders();
	// headers.setContentType(MediaType.APPLICATION_JSON);

	// HttpEntity<HashMap> req = new HttpEntity(request1, headers);

	// RestTemplate restTemplate = new RestTemplate();
	// ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, req,
	// Map.class);

	// System.out.println("7777777777777777777777777777777777777+2");

	// if (resp.getBody().get("status").toString().equals("200")) {
	// Map<String, Object> data = (Map) resp.getBody();
	// String ci=data.get("per_num_doc").toString();
	// System.out.println("-----------------ADMINISTRATIVO------------------");
	// System.out.println("-----------------------CA:
	// "+codigoAdministrativo+"-----------------");
	// System.out.println("---------------------------"+ci+"---------------");
	// }
	// return "index/index";
	// } catch (Exception e) {

	// String msn = "Error: Revise su usuario y contraseña ";
	// model.addAttribute("msn", msn);
	// System.out.println("hola-------------------------------------");
	// return "index/index";
	// }
	// }

	// @RequestMapping(value = "particular", method = RequestMethod.GET)
	// public String particular(HttpServletRequest request, Model model) {
	// System.out.print("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAA++PARTICULAR");
	// return "index/index";
	// }

}