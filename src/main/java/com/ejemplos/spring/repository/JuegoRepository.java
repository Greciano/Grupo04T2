package com.ejemplos.spring.repository;

import java.util.List;

import com.ejemplos.spring.model.Juego;
import com.ejemplos.spring.model.JuegoDTO;

public interface JuegoRepository {

	
	public List<JuegoDTO> getJuego();
	
	public void addJuego(Juego juego);
	
	public JuegoDTO  deleteJuego(int id);
	
	public JuegoDTO updateJuego(int id, JuegoDTO juego);
	
	public JuegoDTO obtenerJuegoPorId(int id);
	
	public List<JuegoDTO> getNintendo();
}
