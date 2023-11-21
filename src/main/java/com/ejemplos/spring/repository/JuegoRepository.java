package com.ejemplos.spring.repository;

import java.util.List;

import com.ejemplos.spring.model.Juego;

public interface JuegoRepository {

	
	public List<Juego> getJuego();
	
	public void addJuego(Juego juego);
	
	public void  deleteJuego(int id);
}
