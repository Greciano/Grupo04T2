package com.ejemplos.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ejemplos.spring.model.JuegoDTO;
import com.ejemplos.spring.repository.JuegoRepositoryImpl;


@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LucaSteamProyect2ApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JuegoRepositoryImpl juegoRepository;

    @Test
    void testGetJuego() {
        // Configura la base de datos de prueba
        jdbcTemplate.execute("INSERT INTO juegos (nombre, fecha, editor, plataforma, genero, eu_sales) VALUES "
                + "('Juego1', 2000, 'Editor1', 'PLATAFORMA1', 'Genero1', 10.5)");

        // Ejecuta la lógica que estás probando
        List<JuegoDTO> actualJuegos = juegoRepository.getJuego();

        // Realiza las aserciones
        assertNotNull(actualJuegos);
        assertEquals(1, actualJuegos.size());
    }
}



//@Test
//void testAddJuego() {
//  Juego juego = new Juego("Nuevo Juego", 2022, "Editor", Plataforma.PS4, Genero.Action, 50.0);
//  juegoRepository.addJuego(juego);
//
//  // Verifica si el juego se ha agregado correctamente a la base de datos
//  String sql = "SELECT * FROM juegos WHERE nombre = 'Nuevo Juego'";
//  JuegoDTO result = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(JuegoDTO.class));
//  assertNotNull(result);
//  assertEquals("Nuevo Juego", result.getNombre());
//  // Agrega más aserciones según sea necesario para verificar la validez de los resultados
//}

//@Test
//void testDeleteJuego() {
//  // Supongamos que ya existe un juego con ID 1 en la base de datos
//  int id = 1;
//  JuegoDTO juegoEliminado = juegoRepository.deleteJuego(id);
//
//  assertNotNull(juegoEliminado);
//  assertEquals(id, juegoEliminado.getId());
//  // Agrega más aserciones según sea necesario para verificar la validez de los resultados
//
//  // Verifica si el juego se ha eliminado correctamente de la base de datos
//  String sql = "SELECT * FROM juegos WHERE id = " + id;
//  assertNull(jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(JuegoDTO.class)));
//}

//@Test
//void testLeerYAlmacenarDatos() {
//  // Agrega lógica de prueba según sea necesario para verificar la validez de los resultados
//  // Puedes usar Mockito para simular el comportamiento del objeto "BufferedReader" y probar cómo se manejan diferentes líneas y casos.
//}

// Agrega más pruebas según sea necesario para otros métodos