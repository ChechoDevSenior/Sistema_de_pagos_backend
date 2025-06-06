package com.sistemadepagosIbero.sistema_pagos_backend_Ibero.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis.Estudiante;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis.Pago;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.repository.EstudianteRepository;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.repository.PagoRepository;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.services.PagoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;


@RestController
@CrossOrigin("*")
public class pagoController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private PagoService pagoService;

    @GetMapping("/estudiantes")
    public List<Estudiante>listarEstudiantes() {
        return estudianteRepository.findAll();
    }
    
    @GetMapping("/estudiantes/{codigo}")
    public Estudiante listarEstudiantePorCodigo(@PathVariable String codigo) {
        return estudianteRepository.findByCodigo(codigo);
    }

    @GetMapping("/estudiantesPorPrograma")
    public List<Estudiante>listarEstudiantesPorPrograma(@RequestParam String programaId) {
        return estudianteRepository.findByProgramaId(programaId);
    }
    
    


    @GetMapping("/pagos")
    public List<Pago>listarPagos() {
        return pagoRepository.findAll();
    }

    @GetMapping("/pago/{id}")
    public Pago listarPagoPorId(@PathVariable Long id) {
        return pagoRepository.findById(id).get();
    }

    @GetMapping("/estudiantes/{codigo}/pagos")
    public List<Pago> listarPorCodigoEstudiante(@PathVariable String codigo) {
        return pagoRepository.findAll();
    }
    
    @GetMapping("/pagosPorStatus")
    public List<Pago> listarPorPagosPorStatus(@RequestParam PagoStatus pagoStatus) {
        return pagoRepository.findAll();
    }
    


}
