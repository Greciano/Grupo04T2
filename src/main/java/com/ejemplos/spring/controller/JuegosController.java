package com.ejemplos.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@Autowired
	private JuegoService juegoService;

	@GetMapping
	@Operation(summary = "Obtener todos los juegos", description = "Devuelve una lista de todos los juegos en la base de datos")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Lista de juegos recuperada con éxito"),
			@ApiResponse(responseCode = "204", description = "No hay juegos en la base de datos") })
	public ResponseEntity<List<JuegoDTO>> getJuegos() {
		List<JuegoDTO> juegos = juegoService.getJuego();
		if (juegos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(juegos, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Eliminar un juego por ID", description = "Elimina un juego de la base de datos por su ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Juego eliminado con éxito"),
			@ApiResponse(responseCode = "404", description = "No se encontró ningún juego con el ID proporcionado") })
	public ResponseEntity<JuegoDTO> deleteJuego(
			@Parameter(description = "ID del juego a eliminar", required = true) @PathVariable int id) {
		JuegoDTO juegoEliminado = juegoService.deleteJuego(id);

		if (juegoEliminado != null) {
			return ResponseEntity.ok(juegoEliminado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@Operation(summary = "Agregar un nuevo juego", description = "Agrega un nuevo juego a la base de datos")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Juego agregado con éxito") })
	public ResponseEntity<?> addJuego(
			@Parameter(description = "Datos del juego a agregar", required = true) @RequestBody Juego juego) {
		juegoService.addJuego(juego);
		return ResponseEntity.noContent().build();
	}

	// Agregar otros métodos, como el de carga inicial, según sea necesario.
}