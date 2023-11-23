package com.ejemplos.spring.service;

import java.util.List;

import com.ejemplos.spring.model.Juego;
import com.ejemplos.spring.model.JuegoDTO;

public interface JuegoService {

    public List<JuegoDTO> getJuego();
	
	public void addJuego(Juego juego);
	
	public JuegoDTO deleteJuego(int id);
	
	public List<JuegoDTO> getNintendo();
}
