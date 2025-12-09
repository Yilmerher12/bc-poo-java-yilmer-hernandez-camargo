package com.consultoria.servicio;

import com.consultoria.modelo.Consultor;
import com.consultoria.modelo.ConsultorSenior;
import com.consultoria.excepciones.ContratoInvalidoException;
import com.consultoria.excepciones.CapacidadAgotadaException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorConsultores {

    // EJERCICIO 1:
    private final List<Consultor> historialConsultores = new ArrayList<>();

    // EJERCICIO 2:
    private final Map<String, Consultor> consultoresPorId = new HashMap<>();

    private static final int MAX_CONSULTORES = 100;


    public void agregarConsultor(Consultor c)
            throws ContratoInvalidoException, CapacidadAgotadaException {

        if (c == null) {
            throw new ContratoInvalidoException("El objeto Consultor no puede ser nulo.");
        }
        if (c.getIdConsultor() == null || c.getIdConsultor().length() != 5) {
            throw new ContratoInvalidoException("El ID del contrato es inválido. Debe tener exactamente 5 caracteres.");
        }

        //Validación 2:
        if (consultoresPorId.containsKey(c.getIdConsultor())) {
            throw new ContratoInvalidoException("Ya existe un consultor con el ID: " + c.getIdConsultor());
        }

        //Validación 3: Límite de Recursos
        if (historialConsultores.size() >= MAX_CONSULTORES) {
            throw new CapacidadAgotadaException("Capacidad máxima de " + MAX_CONSULTORES + " consultores alcanzada.");
        }

        // AGREGAR A AMBAS
        consultoresPorId.put(c.getIdConsultor(), c);
        historialConsultores.add(c);
        System.out.println("✅ Consultor agregado con éxito: " + c.getNombreConsultor());
    }

    public Consultor eliminarConsultor(String id) {
        // Se usa HASHMAP
        Consultor consultorEliminado = consultoresPorId.remove(id);

        // 2. Si se encontró y eliminó, sincronizamos y eliminamos del ArrayList
        if (consultorEliminado != null) {
            historialConsultores.remove(consultorEliminado);
            System.out.println("Consultor con ID " + id + " eliminado.");
        }
        return consultorEliminado;
    }
    public List<Consultor> filtrarSeniorPorAnos(int anosMinimos) {
        // Creacion de una nueva lista
        List<Consultor> consultoresFiltrados = new ArrayList<>();

        // For each para la iteracion
        for (Consultor c : historialConsultores) {

            // 1. Verificamos si es una instancia de ConsultorSenior
            // 2. Verificamos si cumple con los años mínimos
            if (c instanceof ConsultorSenior && c.getAnosDeServicio() >= anosMinimos) {
                consultoresFiltrados.add(c);
            }
        }
        return consultoresFiltrados;
    }

    public Map<String, Integer> contarPorEspecialidad() {
        Map<String, Integer> conteoEspecialidades = new HashMap<>();

        // Iteramos sobre el ArrayList
        for (Consultor c : historialConsultores) {
            String especialidad = c.getEspecialidadConsultor();

            conteoEspecialidades.put( especialidad, conteoEspecialidades.getOrDefault(especialidad, 0) + 1
            );
        }
        return conteoEspecialidades;
    }

    public double calcularCostoTotalMensual(int horasMensuales) {
        double totalCosto = 0;

        // Iteramos sobre el ArrayList
        for (Consultor c : historialConsultores) {
            totalCosto += c.calcularCostoMensualEstimado(horasMensuales);
        }
        return totalCosto;
    }


    public Consultor buscarPorId(String id) {
        return consultoresPorId.get(id); // Lectura instantánea con HashMap
    }


    public List<Consultor> obtenerTodos() {
        return historialConsultores;
    }


    public int cantidad() {
        return historialConsultores.size();
    }


    public void finalizarOperacion() {
        System.out.println("--- Bloque FINALLY: Tarea de limpieza completada ---");
    }

}