package com.sistemadepagosIbero.sistema_pagos_backend_Ibero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis.Pago;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.PagoStatus;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.TypePago;

import java.util.List;


@Repository //Se extiende del repositorio de Java y se menciona la clase, primary key
public interface PagoRepository extends JpaRepository<Pago, Long>{

    //Metodo personalizado para buscar pagos por un estudiante en específico
    List<Pago>findByIdEstudianteCodigo(String codigo);  

    //Método personalizado para buscar los pagos por su estado CREADO, VALIDADO, RECHAZADO
    List<Pago> findByIdStatus(PagoStatus status);

    //Método personalizado para buscar pagos por su tipo EFECTIVO, CHEQUE, TRANSFERENCIA, DEPOSITO
    List<Pago> findByIdType(TypePago type);

    
}
