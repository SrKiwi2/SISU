package com.sisu.sisu.controller.CajaFicha;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class CajaFichaController {

    
    @RequestMapping(value = "universitarioC", method = RequestMethod.GET)
	public Object universitario(HttpServletRequest request, Model model,
			@RequestParam("codigoUniversitario") String ru) {

		System.out.println("EL RU DEL UNIVERSITARIO ES :" + ru);
		System.out.println("-----------------ESTUDIANTE------------------");
		System.out.println("EL RU DEL UNIVERSITARIO ES :" + ru);
		System.out.println("------------RU: " + ru + "------");
		System.out.println("EL RU DEL UNIVERSITARIO ES :" + ru);
		System.out.println("---------------------------------------------");

		Map<String, Object> requests = new HashMap<>();

		requests.put("ru", ru);

		String url = "http://181.115.188.250:9993/v1/service/api/cee024514f4e4b1f970bfb2b6486b421";
		String key = "key 70c8b6fc339aa5e6312dd42edf0636558948bb6008f1a0f867885d5e60e26c57";

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-api-key", key);

		HttpEntity<Map<String, Object>> req = new HttpEntity<>(requests, headers);
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, req, Map.class);

		if (resp.getBody().get("status").toString().equals("200")) {

			Map<String, Object> data = (Map) resp.getBody().get("data");
			String nombreUniversitario = data.get("nombres").toString();
			// String urlImagen = data.get("url_imagen").toString();

			System.out.println("EL NOMBRE DEL UNIVERSITARIO ES " + data.get("nombres").toString());

			if (request.getHeader("X-Requested-With") != null
					&& request.getHeader("X-Requested-With").equals("XMLHttpRequest")) {
				Map<String, Object> responseData = new HashMap<>();
				responseData.put("nombreUniversitario", nombreUniversitario);
				responseData.put("apPaterno", data.get("apellido_paterno").toString());
				responseData.put("apMaterno", data.get("apellido_materno").toString());
				responseData.put("ci", data.get("ci").toString());
				responseData.put("ru", data.get("ru").toString());
				responseData.put("fechaNacimiento", data.get("fecha_nacimiento").toString());
				responseData.put("direccion", data.get("direccion").toString());
				responseData.put("correo", data.get("correo").toString());
				responseData.put("carrera", data.get("carrera").toString());
				responseData.put("celular", data.get("celular").toString());
				responseData.put("tipoSanguineo", data.get("tipo_sanguineo").toString());
				responseData.put("sexo", data.get("sexo").toString());
				responseData.put("estadoMatriculacion", data.get("estado_matriculacion").toString());

				return new ResponseEntity<>(responseData, HttpStatus.OK);
			} else {
				return "index/nombreUniversitarioView";
			}
		}
		return "Error al procesar la solicitud";

		// Manejo de errores u otras lógicas en caso de que la respuesta no sea 200
	}


	
	@RequestMapping(value = "docenteC", method = RequestMethod.GET)
	public Object docenteC(HttpServletRequest request,Model model,
				@RequestParam("codigoDocente") String rd) {
		
		Map<String, Object> request1 = new HashMap<>();
	
		System.out.println("el codigo docente es"+rd);
		
		request1.put("rd",rd);
		
		String url = "http://181.115.188.250:9993/v1/service/api/ae7ce0054d4c4f38a4a92bf1c0422b55";
		String key = "key 70c8b6fc339aa5e6312dd42edf0636558948bb6008f1a0f867885d5e60e26c57";
		
		HttpHeaders headers=new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-api-key", key);
		
		HttpEntity<Map<String, Object>> req = new HttpEntity<>(request1, headers);
		RestTemplate restTemplate= new RestTemplate();
		
		ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, req, Map.class);

		System.out.println("---------------"+resp.getBody().get("status").toString()+"--------------------------");

        if (resp.getBody().get("status").toString().equals("200")) {
        	System.out.println("----------------------------------SS--------");
			Map<String, Object> data = (Map) resp.getBody().get("data");
        	System.out.println("------------RD: "+rd+"---------");
        	System.out.println("------------------------------------------");
        	System.out.println("EL NOMBRE DEL DOCENTE ES "+data.get("nombres").toString());
        	System.out.println("-----------------DOCENTE------------------");
			String DatosDocente = data.get("nombres").toString();
			if (request.getHeader("X-Requested-With") != null &&
			 		request.getHeader("X-Requested-With").equals("XMLHttpRequest")) {
				Map<String, Object> responseDataD = new HashMap<>();
				responseDataD.put("DatosDocente", DatosDocente);
				responseDataD.put("apellidoPaterno",data.get("apellido_paterno").toString());
				responseDataD.put("apellidoMaterno", data.get("apellido_materno").toString());
				responseDataD.put("ci", data.get("ci").toString());
				responseDataD.put("rd", data.get("rd").toString());
				responseDataD.put("gradoAcademicoD", data.get("grado_academico").toString());
				responseDataD.put("titulo", data.get("titulo").toString());
				responseDataD.put("fechaNacimiento", data.get("fecha_nacimiento").toString());
				responseDataD.put("tipoSanguineoD", data.get("tipo_sanguineo").toString());
				responseDataD.put("sexo", data.get("sexo").toString());
				responseDataD.put("direccion", data.get("direccion").toString());
				responseDataD.put("celular", data.get("celular").toString());
				responseDataD.put("correo", data.get("correos").toString());
				// responseDataD.put("asignatura", data.get("asignatura").toString());
				// responseDataD.put("tipodocente", data.get("tipo_docente")).toString();
				// responseDataD.put("carrera", data.get("carrera").toString());
				// responseDataD.put("facultad", data.get("facultad").toString());
				responseDataD.put("activo", data.get("activo").toString());

				return new ResponseEntity<>(responseDataD, HttpStatus.OK);
			}else{
				return "busqueda/GenerarFicha";
			}
		}
		return "Error al procesar la solicitud";
	}
}
