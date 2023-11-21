package com.ejemplos.spring.service;

import java.util.List;

import com.ejemplos.spring.model.Juego;

public interface JuegoService {

    public List<Juego> getJuego();
	
	public void addJuego(Juego juego);
	
	public void  deleteJuego(int id);
}
