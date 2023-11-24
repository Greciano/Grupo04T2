package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Juego;
import com.ejemplos.spring.service.JuegoService;

@SpringBootTest
class SpringTest08 {

    @Autowired
    private JuegoService juegoService;

    @Test
    void comprobarJuegoAddCamp() {
        // Crea un juego con campos vacíos
        Juego juegoConCamposVacios = new Juego();
        // Intenta agregar el juego con campos vacíos
        try {
            juegoService.addJuego(juegoConCamposVacios);
            // Si no se lanza ninguna excepción, significa que la prueba ha fallado
            assertThat(false).isTrue(); // Fuerza el fallo de la prueba si no se lanza una excepción
        } catch (Exception e) {
            // Verifica que la excepción lanzada sea la esperada
            assertThat(e.getMessage()).isEqualTo("Mensaje de error esperado al agregar juego con campos vacíos");
        }
    }
}