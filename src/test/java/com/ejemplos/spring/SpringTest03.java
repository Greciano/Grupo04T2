package com.ejemplos.spring;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringTest03 {

  //Debería acertar aposta
  	@Test
  	void comprobarNombreJuego() {
  		//El assertThat es de AssertJ
  		String name = "Pokemon";
  		boolean result = name.length() < 255;
  		assertThat(result).isTrue();
  	}
}
