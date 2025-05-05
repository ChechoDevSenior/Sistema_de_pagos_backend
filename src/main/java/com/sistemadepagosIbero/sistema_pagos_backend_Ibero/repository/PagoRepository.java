package com.sistemadepagosIbero.sistema_pagos_backend_Ibero.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Importa la interfaz JpaRepository para realizar operaciones CRUD sobre la entidad Pago.
import org.springframework.stereotype.Repository; // Importa la anotación @Repository para marcar esta interfaz como un repositorio en Spring.

import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis.Pago; // Importa la clase Pago, que es la entidad que se gestionará en el repositorio.
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.PagoStatus; // Importa el enum PagoStatus, que representa los diferentes estados de un pago.
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.TypePago; // Importa el enum TypePago, que define los tipos de pago posibles.

import java.util.List; // Importa la clase List para manejar colecciones de objetos de tipo Pago.

@Repository // La anotación @Repository marca esta interfaz como un repositorio de Spring,
            // que proporciona acceso a la base de datos.
public interface PagoRepository extends JpaRepository<Pago, Long> { // Extiende JpaRepository, donde Pago es la entidad
                                                                    // y Long es el tipo de la clave primaria.

    // Método personalizado para buscar pagos de un estudiante específico usando su
    // código único.
    List<Pago> findByEstudianteCodigo(String codigo); // Busca todos los pagos asociados a un estudiante por su código.

    // Método personalizado para buscar pagos según su estado (CREADO, VALIDADO,
    // RECHAZADO).
    List<Pago> findByStatus(PagoStatus status); // Busca todos los pagos con un estado específico.

    // Método personalizado para buscar pagos según su tipo (EFECTIVO, CHEQUE,
    // TRANSFERENCIA, DEPOSITO).
    List<Pago> findByType(TypePago type); // Busca todos los pagos de un tipo específico.
}
