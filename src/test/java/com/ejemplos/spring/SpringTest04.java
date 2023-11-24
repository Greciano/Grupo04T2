package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class SpringTest04 {
	@Test
	void comprobarAñoJuego() {
		int year = 1999;
		boolean result = false;
		int currentYear = LocalDate.now().getYear();
		if (year>=1952 && year<=currentYear) {
			result = true;
		}
		assertThat(result).isTrue();
	}
}
