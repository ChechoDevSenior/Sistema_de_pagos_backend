package com.sistemadepagosIbero.sistema_pagos_backend_Ibero; // Paquete principal de la aplicación.

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication; // Importa SpringApplication, utilizado para lanzar la aplicación Spring Boot.
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa la anotación @SpringBootApplication, que marca la clase como una aplicación Spring Boot.
import org.springframework.context.annotation.Bean;

import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis.Estudiante;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis.Pago;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.PagoStatus;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.TypePago;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.repository.EstudianteRepository;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.repository.PagoRepository;

/**
 * Anotación que habilita las configuraciones necesarias para que esta clase sea
 * la principal de la aplicación Spring Boot. Incluye la configuración
 * automática y el escaneo de componentes.
 */
@SpringBootApplication
public class SistemaPagosBackendIberoApplication { // Clase principal de la aplicación.

	public static void main(String[] args) { // Método main que ejecuta la aplicación.
		// Llama a run() de SpringApplication para iniciar la aplicación Spring Boot.
		SpringApplication.run(SistemaPagosBackendIberoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(EstudianteRepository estudianteRepository, PagoRepository pagoRepository) {
		return args -> {
			// Guarda un estudiante en la BD al iniciar una app
			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Joseph")
					.apellido("Peña")
					.codigo("1050629155")
					.programaId("Diseño Gráfico")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Fabián")
					.apellido("Chaparro")
					.codigo("1033703379")
					.programaId("Ingeniería de sistemas")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Viviana")
					.apellido("Peña")
					.codigo("1234")
					.programaId("Administración de empresas")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Adriana")
					.apellido("Rivera")
					.codigo("1049638845")
					.programaId("Licenciatura en pegagogía infantil")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Alejandro")
					.apellido("Mendoza")
					.codigo("2345")
					.programaId("Seguridad y salud en el trabajo")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Jose")
					.apellido("Ramírez")
					.codigo("80412704")
					.programaId("Filosofía")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Maria")
					.apellido("Chaparro")
					.codigo("52014141")
					.programaId("Administración turistica y hotelera")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Mayerly")
					.apellido("Hoyos")
					.codigo("3456")
					.programaId("Administración Pública")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("David")
					.apellido("Bermudez")
					.codigo("4567")
					.programaId("Ingeniería Electromecánica")
					.build());

			estudianteRepository.save(Estudiante.builder()
					.id(UUID.randomUUID().toString())
					.nombre("Brian")
					.apellido("Vergara")
					.codigo("5678")
					.programaId("Derecho")
					.build());

			// OBTIENE TODOS LOS VALORES POSIBLES ENUMERADOS TYPE PAGO
			TypePago typePago[] = TypePago.values();

			// Crear un objeto random para seleccionar valores aleatorios
			Random random = new Random();

			// itera sobre todos los estudiantes del repositorio
			estudianteRepository.findAll().forEach(estudiante -> {
				// Crear 10 pagos por estudiante
				for (int i = 0; i < 10; i++) {
					// Genere un index aleatorio
					int index = random.nextInt(typePago.length);

					Pago pago = Pago.builder()
							.cantidad(1000 + (int) (Math.random() * 20000))
							.type(typePago[index])
							.status(PagoStatus.CREADO)
							.fecha(LocalDate.now())
							.estudiante(estudiante)
							.build();

					// Guarda el pago en la DB
					pagoRepository.save(pago);
				}
			});
		};
	}
}
