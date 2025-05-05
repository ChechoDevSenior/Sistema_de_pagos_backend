package com.sistemadepagosIbero.sistema_pagos_backend_Ibero.dtos;

import java.time.LocalDate;

import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.TypePago;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewPago {

    private double cantida;
    private TypePago typePago;
    private LocalDate date;
    private String codigoEstudiante;
    
}
