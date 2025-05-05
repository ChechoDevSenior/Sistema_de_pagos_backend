package com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis;


import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Anotación que indica que esta clase es una entidad JPA. 
@Builder //Instancia los objetos.
@Data //Reemplaza los Getters and Setters hashCode y toString. 
@NoArgsConstructor //Genera un constructor sin argumentos. 
@AllArgsConstructor //Reemplaza los metodos constructores.
public class Estudiante {
    
    @Id // Indicar que este campo es la primary key en la DB
    private String id;
    private String nombre;
    private String apellido;

    @Column(unique = true) //Hace que el codigo sea único e irrepetible en la DB 
    private String codigo;

    private String programaId;
    private String foto;
}
