package com.ejemplos.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.model.CustomResponse;
import com.ejemplos.spring.model.Juego;
import com.ejemplos.spring.model.JuegoDTO;
import com.ejemplos.spring.service.JuegoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/juegos")
@Tag(name = "Juegos", description = "Operaciones relacionadas con los juegos")
public class JuegosController {

	private static final Logger logger = LoggerFactory.getLogger(JuegosController.class);

	@Autowired
	private JuegoService juegoService;

	@GetMapping
	@Operation(summary = "Obtener todos los juegos", description = "Devuelve una lista de todos los juegos en la base de datos")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Lista de juegos recuperada con éxito"),
			@ApiResponse(responseCode = "204", description = "No hay juegos en la base de datos") })
	public ResponseEntity<List<JuegoDTO>> getJuegos() {
		logger.info("------ readJuegos (GET) ");
		List<JuegoDTO> juegos = juegoService.getJuego();
		if (juegos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(juegos, HttpStatus.OK);
	}
	
	@GetMapping("/nintendo")
	@Operation(summary = "Obtener todos los juegos de Nintendo", description = "Devuelve una lista de todos los juegos en la base de datos que sean editados por Nintendo.")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Lista de juegos de Nintendo recuperada con éxito"),
	        @ApiResponse(responseCode = "204", description = "No hay juegos de Nintendo en la base de datos")
	})
	public ResponseEntity<List<JuegoDTO>> getNintendo() {
	    List<JuegoDTO> juegosNintendo = juegoService.getNintendo();

	    if (juegosNintendo.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(juegosNintendo, HttpStatus.OK);
	}

	
	

	@DeleteMapping("/{id}")
	@Operation(summary = "Eliminar un juego por ID", description = "Elimina un juego de la base de datos por su ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Juego eliminado con éxito"),
			@ApiResponse(responseCode = "404", description = "No se encontró ningún juego con el ID proporcionado") })
	public ResponseEntity<?> deleteJuego(
			@Parameter(description = "ID del juego a eliminar", required = true) @PathVariable int id) {
		JuegoDTO juegoEliminado = juegoService.deleteJuego(id);

		if (juegoEliminado != null) {
			CustomResponse<JuegoDTO> customResponse = CustomResponse.createSuccessResponse(juegoEliminado);
			return ResponseEntity.ok(customResponse);
		} else {
			CustomResponse<Void> customResponse = CustomResponse
					.createNotFoundResponse("No se encontró ningún juego con el ID proporcionado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customResponse);
		}

	}

	@PostMapping("/add")
	@Operation(summary = "Agregar un nuevo juego", description = "Agrega un nuevo juego a la base de datos")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Juego agregado con éxito") })
	public ResponseEntity<CustomResponse<String>> addJuego(
	        @Parameter(description = "Datos del juego a agregar", required = true) @RequestBody Juego juego) {
	    logger.info("------ addJuego (POST)");
	    juegoService.addJuego(juego);
	    String mensaje = "Juego agregado con éxito: " + juego.getNombre();
	    return ResponseEntity.status(HttpStatus.CREATED)
	            .body(new CustomResponse<>(201, mensaje, null));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<JuegoDTO> updateJuego(@PathVariable int id, @RequestBody JuegoDTO juego){
		juegoService.updateJuego(id,juego);
		return ResponseEntity.noContent().build();
	}
	
	// Agregar otros métodos, como el de carga inicial, según sea necesario.
}