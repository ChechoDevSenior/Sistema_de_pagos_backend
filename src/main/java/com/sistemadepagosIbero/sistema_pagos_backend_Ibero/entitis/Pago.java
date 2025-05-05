package com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis;

import java.time.LocalDate; // Importa la clase LocalDate para trabajar con fechas.

import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.PagoStatus; // Importa el enum PagoStatus, que define el estado de un pago.
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.TypePago; // Importa el enum TypePago, que define los tipos de pago.

import jakarta.persistence.Entity; // Importa la anotación @Entity, que marca la clase como una entidad JPA.
import jakarta.persistence.GeneratedValue; // Importa la anotación @GeneratedValue para la generación automática del valor de la clave primaria.
import jakarta.persistence.GenerationType; // Importa la clase GenerationType para definir el tipo de generación de la clave primaria.
import jakarta.persistence.Id; // Importa la anotación @Id para especificar la clave primaria.
import jakarta.persistence.ManyToOne; // Importa la anotación @ManyToOne para definir la relación de muchos a uno con la clase Estudiante.
import lombok.AllArgsConstructor; // Importa la anotación @AllArgsConstructor que genera un constructor con todos los atributos.
import lombok.Builder; // Importa la anotación @Builder, que proporciona un patrón de diseño para la creación de objetos.
import lombok.Data; // Importa la anotación @Data, que genera los métodos getters, setters, hashCode y toString.
import lombok.NoArgsConstructor; // Importa la anotación @NoArgsConstructor que genera un constructor sin argumentos.

@Entity // Anotación que indica que esta clase es una entidad JPA. Se utiliza para mapear la clase a una tabla en la base de datos.
@Builder // La anotación Builder genera un patrón de diseño que facilita la creación de instancias de esta clase de manera más legible.
@Data // La anotación @Data genera automáticamente los métodos getters, setters, toString y hashCode para la clase.
@NoArgsConstructor // La anotación @NoArgsConstructor genera un constructor sin parámetros.
@AllArgsConstructor // La anotación @AllArgsConstructor genera un constructor con todos los parámetros.

public class Pago {

    @Id // La anotación @Id indica que el campo id es la clave primaria en la base de datos.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La anotación @GeneratedValue se utiliza para definir la estrategia de generación de la clave primaria, en este caso, autoincrementable.
    private long id; // Identificador único del pago.

    private LocalDate fecha; // Fecha del pago.

    private double cantidad; // Monto del pago.

    private TypePago type; // Tipo de pago, basado en el enum TypePago.

    private PagoStatus status; // Estado del pago, basado en el enum PagoStatus.

    private String file; // Archivo asociado al pago (por ejemplo, un recibo o comprobante).

    @ManyToOne // La anotación @ManyToOne define una relación de "muchos a uno" con la clase Estudiante.
    private Estudiante estudiante; // El estudiante relacionado con este pago.

}
