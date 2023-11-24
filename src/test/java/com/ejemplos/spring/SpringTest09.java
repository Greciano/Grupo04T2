package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Juego;
import com.ejemplos.spring.service.JuegoService;

@SpringBootTest
class SpringTest09 {

    @Autowired
    private JuegoService juegoService;

    @Test
    void comprobarJuegoAddTipoDatoIncorrecto() {
        // Crea un juego con un tipo de dato incorrecto (por ejemplo, una cadena en lugar de un número para la fecha)
        Juego juegoConTipoDatoIncorrecto = new Juego();
        juegoConTipoDatoIncorrecto.setFecha(2); // Ajusta el valor para que sea incorrecto
        // Intenta agregar el juego con tipo de dato incorrecto
        try {
            juegoService.addJuego(juegoConTipoDatoIncorrecto);
            // Si no se lanza ninguna excepción, significa que la prueba ha fallado
            assertThat(false).isTrue(); // Fuerza el fallo de la prueba si no se lanza una excepción
        } catch (Exception e) {
            // Verifica que la excepción lanzada sea la esperada
            assertThat(e.getMessage()).isEqualTo("Mensaje de error esperado al agregar juego con tipo de dato incorrecto");
        }
    }
}
