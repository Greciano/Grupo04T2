package com.ejemplos.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejemplos.spring.service.JuegoService;
import com.ejemplos.spring.service.JuegoServiceImpl;



@SpringBootApplication
public class LucaSteamProyect2Application {

	public static void main(String[] args) {
		SpringApplication.run(LucaSteamProyect2Application.class, args);
		JuegoService service = new JuegoServiceImpl();
		
		
	}

}
