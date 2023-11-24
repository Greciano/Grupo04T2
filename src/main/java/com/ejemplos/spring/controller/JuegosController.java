package com.ejemplos.spring.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

import com.ejemplos.spring.model.Genero;
import com.ejemplos.spring.model.Juego;
import com.ejemplos.spring.model.JuegoDTO;
import com.ejemplos.spring.model.Plataforma;
import com.ejemplos.spring.service.JuegoService;

@RestController
@RequestMapping("/juegos")
public class JuegosController {
	
	@Autowired
    private JuegoService juegoService;
	
	@GetMapping
    public ResponseEntity<List<JuegoDTO>> getJuegos() {
        List<JuegoDTO> juegos = juegoService.getJuego();
        if (juegos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(juegos, HttpStatus.OK);
    }
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteJuego(@PathVariable int id) {
	        juegoService.deleteJuego(id);
	        return ResponseEntity.noContent().build();
	    }
	 
	 @PostMapping
	 public ResponseEntity<Void> addJuego(@RequestBody Juego juego) {
	     juegoService.addJuego(juego);
	     return ResponseEntity.status(HttpStatus.CREATED).build();
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<Void> updateJuego(@PathVariable int id, @RequestBody JuegoDTO juegoDTO) {
	     juegoDTO.setId(id);
	     juegoService.updateJuego(juegoDTO);
	     return ResponseEntity.status(HttpStatus.OK).build();
	 }
}
