package com.ejemplos.spring.config;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

public class OpenApiConfig {

	@Bean
	public OpenAPI StudentOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Juegos API").description("Documentación de la Juegos API").version("v1.0")
						.contact(new Contact().name("Alvaro,Victor,Adrian,Mori").url("https://grupo04P2.es")
								.email("grupo04P2@gmail.es"))
						.license(new License().name("LICENSE").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation().description("Descripcion del proyecto")
						.url("https://grupo04P2.es"));
	}
}
