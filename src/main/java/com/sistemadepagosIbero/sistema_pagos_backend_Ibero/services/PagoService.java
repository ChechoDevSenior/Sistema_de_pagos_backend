package com.sistemadepagosIbero.sistema_pagos_backend_Ibero.services;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis.Estudiante;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.entitis.Pago;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.PagoStatus;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.enums.TypePago;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.repository.EstudianteRepository;
import com.sistemadepagosIbero.sistema_pagos_backend_Ibero.repository.PagoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional // Para asegurar que los metodos de la clase se ejecuten dentro de una
               // transacción
public class PagoService {

    // inyección de dependencias de PagoRepository para interactuar con la DB de
    // pagos
    @Autowired
    private PagoRepository pagoRepository;

    // inyección de dependencias de EstudianteRepository para obtener información de
    // los estudiantes desde la DB
    @Autowired
    private EstudianteRepository estudianteRepository;

    /**
     * Metodo para guardar el pago en la Db y almacenar un archivo PDf en el
     * servidor
     * 
     * @param file             archivo PDF que se subira al servidor
     * @param cantidad         monto del pago realizado
     * @param type             tipo de pago EFECTIVO, CHEQUE, TRANSFERENCIA,
     *                         DEPOSITO
     * @param date             fecha en que se realizo el pago
     * @param codigoEstudiante codigo del estudiante que realiza el pago
     * @return objeto pago guardado en la DB
     * @throws IOException execepcion lanzada si ocurre un error al manejar el file
     *                     PDF
     */

    public Pago savePago(MultipartFile file, double cantidad, TypePago type, LocalDate date,
            String codigoEstudianteString) throws IOException {
        /*
         * construir la ruta donde se guardará el archivo dentro del sistema
         * System.getProperty("user.home"): obtiene la ruta del directorio personal del
         * usuario del actual SO
         * Paths.get: construir una ruta del directorio personal en la carpeta
         * "enset-data/pagos"
         */

        Path folderPath = Paths.get(System.getProperty("user.home"), "enset-data", "pagos");

        // verificar si la carpeta ya existe, sino se debe crear.
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        // generamos un nombre unico para el archivo usando UUID (identificador unico
        // universal)
        String fileName = UUID.randomUUID().toString();

        // Construimos la ruta completa del archivo agregando la extensión .PDF
        Path filePath = Paths.get(System.getProperty("user.home"), "enset-data", "pagos", fileName + ".pdf");

        // guardamos el archivo recibido en la ubicación especificada dentro del sistema
        // de archivos
        Files.copy(file.getInputStream(), filePath);

        // buscamos el estudiante que realiza el pago con su codigo
        Estudiante estudiante = estudianteRepository.findByCodigo(codigoEstudianteString);

        // Creamos un nuevo objeto pago utilizando el patron de diseño builder
        Pago pago = Pago.builder()
                .type(type)
                .status(PagoStatus.CREADO)// estado inicial del pago
                .fecha(date)
                .estudiante(estudiante)
                .cantidad(cantidad)
                .file(filePath.toUri().toString()) // ruta del archivo PDF almacenado
                .build(); // construcción final del objeto

        return pagoRepository.save(pago);

    }

    public byte[] getArchivoPorId(Long pagoId) throws IOException {

        // Busca un objeto pago en la DB por su ID
        Pago pago = pagoRepository.findById(pagoId).get();

        /**
         * pago.getFile: obtiene la URI del archivo guardado como una cadena de texto
         * URI.create : convierte la cadena de texto en un objeto URI
         * Path.of : convierte la URI en un path para poder acceder al archivo
         * Files.readAllBytes: lee el contenido del archivo y devuelve en un array
         * vector de bytes
         * esto va permitir obtener contenido del archivo para su posterior uso por
         * ejemplo descargarlo
         */
        return Files.readAllBytes(Path.of(URI.create(pago.getFile())));
    }

    public Pago actualizarPagoPorStatus(PagoStatus status, Long id) {

        // Busca un objeto pago en la DB por su ID
        Pago pago = pagoRepository.findById(id).get();

        // Actualiza el estado del pago (VALIDADO o RECHAZADO)
        pago.setStatus(status);

        // guarda el objeto pago actualizado en la DB y lo devuelve
        return pagoRepository.save(pago);

    }

}
