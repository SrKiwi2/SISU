package com.sisu.sisu.controller.CajaFicha;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.sisu.sisu.Service.FichaService;
import com.sisu.sisu.Service.HistorialSeguroService;
import com.sisu.sisu.Service.IAseguradoService;
import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.entitys.Asegurado;
import com.sisu.sisu.entitys.Dip;
import com.sisu.sisu.entitys.EstadoSeguro;
import com.sisu.sisu.entitys.Ficha;
import com.sisu.sisu.entitys.GradoAcademico;
import com.sisu.sisu.entitys.HistorialSeguro;
import com.sisu.sisu.entitys.Institucion;
import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.TipoSeguro;
import com.sisu.sisu.entitys.TiposEstadoCivil;

import net.bytebuddy.asm.Advice.Return;

@Controller
public class CajaFichaController {

	@Autowired
	private IPersonaService personaService;

	@Autowired
	private IAseguradoService aseguradoService;

	@Autowired
	private HistorialSeguroService historialSeguroService;

	@Autowired
	private FichaService fichaService;

	@RequestMapping(value = "/Ficha", method = RequestMethod.GET)
	public String ficha(Model model) {
		
		System.out.println("11111111111111111111111111111111111111111111");
		return "busqueda/GenerarFicha"; 
	}

    @RequestMapping(value = "universitarioC", method = RequestMethod.GET)
	public ResponseEntity<Object> universitario(HttpServletRequest request, Model model,
			@RequestParam("codigoUniversitario") String ru) {

		if (ru == null || ru.isEmpty()) {
			return ResponseEntity.badRequest().body("El código universitario no puede estar vacío.");
		}

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

				Persona univPersona = personaService.findByCi(data.get("ci").toString());

				if (univPersona != null) {
					personaUniCreada = univPersona;

				}else{

					univPersona = new Persona();
					Dip dip = new Dip();
					GradoAcademico gradoAcademico = new GradoAcademico();
					TiposEstadoCivil tiposEstadoCivil = new TiposEstadoCivil();

					dip.setIdDip(10);
					gradoAcademico.setIdGradoAcademico(1);
					tiposEstadoCivil.setIdTipoEstadoCivil(1);

					univPersona.setEstado("RU");
					univPersona.setNombres(data.get("nombres").toString());
	    			univPersona.setApPaterno(data.get("apellido_paterno").toString());
	    			univPersona.setApMaterno(data.get("apellido_materno").toString());
	    			univPersona.setCi(data.get("ci").toString());
	    			univPersona.setDireccion(data.get("direccion").toString());
	    			univPersona.setCelular(Integer.parseInt(data.get("celular").toString()));
	    			univPersona.setSexo(data.get("sexo").toString());
					univPersona.setDip(dip);
					univPersona.setGrado_academico(gradoAcademico);
					univPersona.setTipos_estado_civil(tiposEstadoCivil);
	    			univPersona.setFecha_nac(LocalDate.parse(data.get("fecha_nacimiento").toString()));
					
					personaService.save(univPersona);

					personaUniCreada = univPersona;
				}

				Asegurado codUniAseguradoExiste =  aseguradoService.findAseguradoByPersonaId(univPersona.getIdPersona());
				
				if (codUniAseguradoExiste != null) {
					
					codUniAseguradoCreado = codUniAseguradoExiste;

				}else{
					String codigoAsegurado = generateCodigoAsegurado(univPersona);

					Asegurado asegurado = new Asegurado();

					// Después de guardar el asegurado

					asegurado.setCodigoAsegurado(codigoAsegurado);
					asegurado.setPersona(univPersona);
					asegurado.setEstado("A");
					aseguradoService.save(asegurado);

					codUniAseguradoCreado = asegurado;

					System.out.println("/------------------------------------------------/");
					System.out.println("SE GENERO EL CODIGO ASEGURADO PARA: " + univPersona.getNombres());
					System.out.println("/------------------------------------------------/");

					EstadoSeguro estadoSeguro = new EstadoSeguro();
					Institucion institucion = new Institucion();
					TipoSeguro tipoSeguro = new TipoSeguro();

					estadoSeguro.setIdEstadoSeguro(1);
					institucion.setIdInstitucion(1);
					tipoSeguro.setIdTipoSeguro(1);

					HistorialSeguro historialSeguro = new HistorialSeguro();
					historialSeguro.setCodigoSeguroPrincipal(codigoAsegurado);
					historialSeguro.setEstado("A"); // (o el estado que desees)
					historialSeguro.setFechaAlta(new Date());
					historialSeguro.setFechaBaja(new Date());
					historialSeguro.setTitularHS(true);
					historialSeguro.setAsegurado(asegurado);
					historialSeguro.setEstado_seguro(estadoSeguro);
					historialSeguro.setInstitucion(institucion);
					historialSeguro.setTipo_seguro(tipoSeguro);
					historialSeguroService.save(historialSeguro);
				}

				return new ResponseEntity<>(responseData, HttpStatus.OK);
			} else {
				return ResponseEntity.ok("index/nombreUniversitarioView");
			}
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");

		// Manejo de errores u otras lógicas en caso de que la respuesta no sea 200
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

	private Persona personaUniCreada;
	private Asegurado codUniAseguradoCreado;

	@RequestMapping(value = "/generarFichaCaja", method = RequestMethod.POST)
	public String generarFicha(Model model) {
	
		Asegurado asegurado = aseguradoService.findAseguradoByPersonaId(personaUniCreada.getIdPersona());

		Ficha existeFicha = fichaService.findFichaByAseguradoId(codUniAseguradoCreado.getIdAsegurado());

		if (existeFicha != null) {
			System.out.println("YA TIENES UNA FICHA PARIENTE");
		}else{
			Ficha ficha = new Ficha();
			ficha.setEstado("A");
			ficha.setFechaRegistroFichaa(new Date());
			ficha.setAsegurado(asegurado);
			fichaService.save(ficha);
		}
	    return "redirect:/inicioCliente";
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
