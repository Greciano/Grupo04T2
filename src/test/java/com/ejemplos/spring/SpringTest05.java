package com.ejemplos.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ejemplos.spring.model.Juego;
import com.ejemplos.spring.model.JuegoDTO;

import com.ejemplos.spring.model.JuegoDTO;
import com.ejemplos.spring.repository.JuegoRepositoryImpl;

@SpringBootTest
public class SpringTest05 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JuegoRepositoryImpl juegoRepository;

    @Test
    void testDeleteJuego() {
        // Supongamos que ya existe un juego con ID 1 en la base de datos
        int id = 20;
        JuegoDTO juegoEliminado = juegoRepository.deleteJuego(id);

        String sql = "SELECT id FROM juegos WHERE id = " + id;
        assertTrue(jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(JuegoDTO.class)).isEmpty());
    }
    
//    @Test
//    void testJuegos() {
//    	boolean resultado = false;
//    	List<Juego> games = juegoRepository.getJuegos();
//    	Juego game = new Juego("Pokemon");
//    	if (games.contains(game)) {
//    		resultado = true;
//    	}
//    }
}
