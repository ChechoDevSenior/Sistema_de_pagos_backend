package com.sistemadepagosIbero.sistema_pagos_backend_Ibero; // Paquete principal de la aplicación.

import org.springframework.boot.SpringApplication; // Importa SpringApplication, utilizado para lanzar la aplicación Spring Boot.
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa la anotación @SpringBootApplication, que marca la clase como una aplicación Spring Boot.

@SpringBootApplication // Anotación que habilita las configuraciones necesarias para que esta clase sea
						// la principal de la aplicación Spring Boot. Incluye la configuración
						// automática y el escaneo de componentes.
public class SistemaPagosBackendIberoApplication { // Clase principal de la aplicación.

	public static void main(String[] args) { // Método main que ejecuta la aplicación.
		SpringApplication.run(SistemaPagosBackendIberoApplication.class, args); // Llama a run() de SpringApplication
																				// para iniciar la aplicación Spring
																				// Boot.
	}
}
