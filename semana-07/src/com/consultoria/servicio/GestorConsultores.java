package com.consultoria.servicio;

import com.consultoria.modelo.Consultor;
import com.consultoria.excepciones.ContratoInvalidoException;
import com.consultoria.excepciones.CapacidadAgotadaException;
import java.util.ArrayList;

public class GestorConsultores {

    private final ArrayList<Consultor> equipoConsultores = new ArrayList<>();
    private static final int MAX_CONSULTORES = 2; // Límite bajo para probar CapacidadAgotadaException

    /**
     * Agrega un nuevo consultor, validando las reglas de negocio.
     * Obliga a manejar las excepciones personalizadas (checked exceptions).
     */
    public void agregarConsultor(Consultor c)
            throws ContratoInvalidoException, CapacidadAgotadaException {

        // --- Validación 1: Contrato Inválido (Nulo o datos incompletos)
        if (c == null) {
            throw new ContratoInvalidoException("El objeto Consultor no puede ser nulo.");
        }
        // Validamos la regla que causó el error en el Main anterior: ID
        if (c.getIdConsultor() == null || c.getIdConsultor().length() != 5) {
            throw new ContratoInvalidoException(
                    "El ID del contrato es inválido. Debe tener exactamente 5 caracteres."
            );
        }

        // --- Validación 2: Capacidad Agotada (Límite de recursos)
        if (equipoConsultores.size() >= MAX_CONSULTORES) {
            throw new CapacidadAgotadaException(
                    "Capacidad máxima de " + MAX_CONSULTORES + " consultores alcanzada. No se puede contratar más personal."
            );
        }

        // Si todas las validaciones pasan
        equipoConsultores.add(c);
        System.out.println("✅ Contrato validado y consultor agregado: " + c.getNombreConsultor());
    }

    /**
     * Simula una operación que requiere limpieza, para el uso de 'finally'.
     */
    public void finalizarOperacion() {
        // En una aplicación real, esto cerraría una conexión a base de datos o un archivo.
        System.out.println("--- Bloque FINALLY: Tarea de limpieza completada ---");
    }
}