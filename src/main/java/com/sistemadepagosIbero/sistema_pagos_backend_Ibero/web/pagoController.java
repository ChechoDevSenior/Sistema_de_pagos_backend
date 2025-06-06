package com.sistemadepagosIbero.sistema_pagos_backend_Ibero.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis.Estudiante;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis.Pago;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.PagoStatus;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.TypePago;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.repository.EstudianteRepository;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.repository.PagoRepository;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.services.PagoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    @GetMapping("/estudiantes/{codigo}")
    public Estudiante listarEstudiantePorCodigo(@PathVariable String codigo) {
        return estudianteRepository.findByCodigo(codigo);
    }

    @GetMapping("/estudiantesPorPrograma")
    public List<Estudiante> listarEstudiantesPorPrograma(@RequestParam String programaId) {
        return estudianteRepository.findByProgramaId(programaId);
    }

    @GetMapping("/pagos")
    public List<Pago> listarPagos() {
        return pagoRepository.findAll();
    }

    @GetMapping("/pago/{id}")
    public Pago listarPagoPorId(@PathVariable Long id) {
        return pagoRepository.findById(id).get();
    }

    @GetMapping("/estudiantes/{codigo}/pagos")
    public List<Pago> listarPorCodigoEstudiante(@PathVariable String codigo) {
        return pagoRepository.findByEstudianteCodigo(codigo);
    }

    @GetMapping("/pagosPorStatus")
    public List<Pago> listarPorPagosPorStatus(@RequestParam PagoStatus status) {
        return pagoRepository.findByStatus(status);
    }

    @GetMapping("/pagos/porTipo")
    public List<Pago> listarPorPagosPorType(@RequestParam TypePago type) {
        return pagoRepository.findByType(type);
    }

    @PutMapping("pagos/{pagoId}/actulizarPago")
    public Pago actualizarStatusPago(@RequestParam PagoStatus status, @PathVariable Long pagoId) {
        return pagoService.actualizarPagoPorStatus(status, pagoId);
    }

    @PostMapping(path = "/pagos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Pago guardaPago(
            @RequestParam("file") MultipartFile file,
            double cantidad,
            TypePago type,
            LocalDate date,
            String codigoEstudiante) throws IOException {
        return pagoService.savePago(file, cantidad, type, date, codigoEstudiante);
    }

    @GetMapping(value = "/pagoFile/{pagoId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] listarArchivoPorId(@PathVariable Long pagoId) throws IOException {
        return pagoService.getArchivoPorId(pagoId);
    }

}
