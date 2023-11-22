package com.ejemplos.spring.repository;

import java.util.List;

import com.ejemplos.spring.model.Juego;
import com.ejemplos.spring.model.JuegoDTO;

public interface JuegoRepository {

	
	public List<JuegoDTO> getJuego();
	
	public void addJuego(Juego juego);
	
	public void  deleteJuego(int id);
}
