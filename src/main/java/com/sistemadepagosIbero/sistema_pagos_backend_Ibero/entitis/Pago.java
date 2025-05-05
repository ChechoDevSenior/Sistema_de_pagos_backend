package com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis;

import java.time.LocalDate;

import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.PagoStatus;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.TypePago;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Anotación que indica que esta clase es una entidad JPA. 
@Builder //Instancia los objetos.
@Data //Reemplaza los Getters and Setters hashCode y toString. 
@NoArgsConstructor //Genera un constructor sin argumentos. 
@AllArgsConstructor //Reemplaza los metodos constructores.
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate fecha;
    private double cantidad;
    private TypePago type;
    private PagoStatus status;
    private String file;

    @ManyToOne
    private Estudiante estudiante;
    

}
