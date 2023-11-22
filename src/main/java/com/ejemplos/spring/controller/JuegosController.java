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
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<List<JuegoDTO>> getAllUsers() {
        List<JuegoDTO> juegos = juegoService.getJuego();
        if (juegos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(juegos, HttpStatus.OK);
    }

	

	

}
