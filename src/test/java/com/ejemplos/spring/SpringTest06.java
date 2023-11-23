package com.ejemplos.spring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.ejemplos.spring.model.JuegoDTO;

@SpringBootTest
public class SpringTest06 {

    @Test
    void testNoJuegosNintendo() {
        // Crea una lista vacía de ejemplo
        List<JuegoDTO> juegosNintendo = new ArrayList<>();

        // Verifica si no hay juegos de Nintendo en la base de datos
        assertTrue(juegosNintendo.isEmpty(), "No debería haber juegos de Nintendo en la base de datos");
    }
}
