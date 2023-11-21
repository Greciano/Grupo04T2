package com.ejemplos.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejemplos.spring.model.Juego;
import com.ejemplos.spring.repository.JuegoRepository;

@Service
public class JuegoServiceImpl implements JuegoService{

	@Autowired
	private JuegoRepository repo;
	
	@Override
	public List<Juego> getJuego() {
		return repo.getJuego();
	}

	@Override
	public void addJuego(Juego juego) {
		repo.addJuego(juego);
	}

	@Override
	public void deleteJuego(int id) {
		repo.deleteJuego(id);
	}
}
