package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringTest02 {

    @Test
    void checkRightAddress() {
        File archivo = new File("src/main/resources/vgsales.csv");
        boolean comprobarExiste = false;
        if(archivo.exists()) {
            comprobarExiste = true;
        }

        assertThat(comprobarExiste).isTrue();
    }

}