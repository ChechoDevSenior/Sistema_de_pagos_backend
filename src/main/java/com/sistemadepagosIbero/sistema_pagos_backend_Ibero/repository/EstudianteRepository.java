package com.sistemadepagosIbero.sistema_pagos_backend_Ibero.repository;

import java.util.List; // Importa la clase List para trabajar con colecciones de objetos.

import org.springframework.data.jpa.repository.JpaRepository; // Importa la interfaz JpaRepository, que proporciona operaciones CRUD para la entidad Estudiante.
import org.springframework.stereotype.Repository; // Importa la anotación @Repository, que indica que esta interfaz es un repositorio de Spring Data JPA.

import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis.Estudiante; // Importa la clase Estudiante, que es la entidad que se gestionará en el repositorio.

@Repository // La anotación @Repository marca esta interfaz como un componente de repositorio para manejar la persistencia de datos de la entidad Estudiante.
public interface EstudianteRepository extends JpaRepository<Estudiante, String> { // Extiende de JpaRepository para heredar métodos CRUD básicos. El primer parámetro es la entidad (Estudiante) y el segundo es el tipo de la clave primaria (String).

    // Método personalizado que busca un estudiante por su código único.
    Estudiante findByCodigo(String codigo); // Busca un estudiante en la base de datos según su código único.

    // Método personalizado que retorna una lista de estudiantes que pertenecen a un programa específico.
    List<Estudiante> findByProgramaId(String programaId); // Busca estudiantes por el identificador de su programa.
}
