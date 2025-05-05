package com.sistemadepagosIbero.sistema_pagos_backend_Ibero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis.Estudiante;

@Repository //Se extiende del repositorio de Java y se menciona la clase, primary key
public interface EstudianteRepository extends JpaRepository<Estudiante,String> {

    //Método personalizado que busque un estudiante por su código único
    Estudiante findByCodigo( String codigo);

    //Método personalizado que me muestre una lista de estudiantes que pertencen a un programa en específico
    List<Estudiante> findByProgramaId(String programaId);
    
}
