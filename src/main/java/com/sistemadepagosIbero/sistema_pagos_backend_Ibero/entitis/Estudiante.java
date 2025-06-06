package com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis;

//import org.springframework.data.annotation.Id; // Línea comentada, que podría ser usada si se requiere la anotación @Id de Spring Data en lugar de la de JPA.

import jakarta.persistence.Column; // Importa la anotación @Column para definir propiedades de columnas en la base de datos.
import jakarta.persistence.Entity; // Importa la anotación @Entity, que marca la clase como una entidad JPA.
import jakarta.persistence.Id; // Importa la anotación @Id para especificar la clave primaria.

import lombok.AllArgsConstructor; // Importa la anotación @AllArgsConstructor que genera un constructor con todos los atributos.
import lombok.Builder; // Importa la anotación @Builder, que proporciona un patrón de diseño para la creación de objetos.
import lombok.Data; // Importa la anotación @Data, que genera los métodos getters, setters, hashCode y toString.
import lombok.NoArgsConstructor; // Importa la anotación @NoArgsConstructor que genera un constructor sin argumentos.

@Entity // Anotación que indica que esta clase es una entidad JPA. Se utiliza para mapear la clase a una tabla en la base de datos.
@Builder // La anotación Builder genera un patrón de diseño que facilita la creación de instancias de esta clase de manera más legible.
@Data // La anotación @Data genera automáticamente los métodos getters, setters, toString y hashCode para la clase.
@NoArgsConstructor // La anotación @NoArgsConstructor genera un constructor sin parámetros.
@AllArgsConstructor // La anotación @AllArgsConstructor genera un constructor con todos los parámetros.

public class Estudiante {
    
    @Id // Indica que el campo id es la clave primaria de la tabla en la base de datos.
    private String id; // Identificador único del estudiante.

    private String nombre; // Nombre del estudiante.

    private String apellido; // Apellido del estudiante.

    @Column(unique = true) // La anotación @Column hace que la columna "codigo" sea única en la base de datos, evitando duplicados.
    private String codigo; // Código único del estudiante.

    private String programaId; // Identificador del programa al que pertenece el estudiante.

    private String foto; // Ruta o nombre de la foto del estudiante.
}
