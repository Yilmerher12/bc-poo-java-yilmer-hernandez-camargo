package com.consultoria.servicio;

import com.consultoria.modelo.Consultor;
import com.consultoria.modelo.ConsultorSenior;
import com.consultoria.modelo.ConsultorJunior;
import com.consultoria.excepciones.ContratoInvalidoException;
import com.consultoria.excepciones.CapacidadAgotadaException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GestorConsultores {

    private final List<Consultor> historialConsultores = new ArrayList<>();
    private final Map<String, Consultor> consultoresPorId = new HashMap<>();
    private static final int MAX_CONSULTORES = 100;
    private static final String ARCHIVO_DATOS = "datos_consultores.csv";

    //CRUD
    public void agregarConsultor(Consultor c)
            throws ContratoInvalidoException, CapacidadAgotadaException {

        if (c == null || c.getIdConsultor() == null || c.getIdConsultor().length() != 5) {
            throw new ContratoInvalidoException("El ID del contrato es inválido. Debe tener exactamente 5 caracteres.");
        }
        if (consultoresPorId.containsKey(c.getIdConsultor())) {
            throw new ContratoInvalidoException("Ya existe un consultor con el ID: " + c.getIdConsultor());
        }
        if (historialConsultores.size() >= MAX_CONSULTORES) {
            throw new CapacidadAgotadaException("Capacidad máxima de " + MAX_CONSULTORES + " consultores alcanzada.");
        }

        consultoresPorId.put(c.getIdConsultor(), c);
        historialConsultores.add(c);
        System.out.println("Consultor agregado con éxito: " + c.getNombreConsultor());
    }

    public Consultor buscarPorId(String id) {
        return consultoresPorId.get(id);
    }

    public Consultor eliminarConsultor(String id) {
        Consultor consultorEliminado = consultoresPorId.remove(id);
        if (consultorEliminado != null) {
            historialConsultores.remove(consultorEliminado);
            System.out.println("🗑Consultor con ID " + id + " eliminado.");
        }
        return consultorEliminado;
    }

    public List<Consultor> obtenerTodos() {
        return historialConsultores;
    }

    public int cantidad() {
        return historialConsultores.size();
    }

    // Filtrado y estadisticas

    public List<Consultor> filtrarSeniorPorAnos(int anosMinimos) {
        List<Consultor> consultoresFiltrados = new ArrayList<>();

        for (Consultor c : historialConsultores) {
            if (c instanceof ConsultorSenior && c.getAnosDeServicio() >= anosMinimos) {
                consultoresFiltrados.add(c);
            }
        }
        return consultoresFiltrados;
    }

    public double calcularCostoTotalMensual(int horasMensuales) {
        double totalCosto = 0;
        for (Consultor c : historialConsultores) {
            totalCosto += c.calcularCostoMensualEstimado(horasMensuales);
        }
        return totalCosto;
    }

    public Map<String, Integer> contarPorEspecialidad() {
        Map<String, Integer> conteoEspecialidades = new HashMap<>();

        for (Consultor c : historialConsultores) {
            String especialidad = c.getEspecialidadConsultor();

            conteoEspecialidades.put(
                    especialidad,
                    conteoEspecialidades.getOrDefault(especialidad, 0) + 1
            );
        }
        return conteoEspecialidades;
    }

    //PERSISTENCIA DE DATOS

    public void guardarConsultores() {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(ARCHIVO_DATOS))) {
            for (Consultor c : historialConsultores) {
                String tipo = (c instanceof ConsultorSenior) ? "SENIOR" : "JUNIOR";
                String linea = String.format("%s,%s,%s,%s,%.2f,%d",
                        tipo, c.getIdConsultor(), c.getNombreConsultor(), c.getEspecialidadConsultor(), c.getTarifaPorHoraBase(), c.getAnosDeServicio());
                escritor.println(linea);
            }
            System.out.println("\nDatos guardados exitosamente en: " + ARCHIVO_DATOS);
        } catch (IOException e) {
            System.err.println("ERROR al guardar los datos: " + e.getMessage());
        }
    }

    public void cargarConsultores() {
        File archivo = new File(ARCHIVO_DATOS);
        if (!archivo.exists()) {
            System.out.println("Archivo de datos no encontrado. Iniciando con lista vacía.");
            return;
        }

        historialConsultores.clear();
        consultoresPorId.clear();

        try (Scanner lector = new Scanner(archivo)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(",");
                if (partes.length < 6) continue;

                String tipo = partes[0];
                String id = partes[1];
                String nombre = partes[2];
                String especialidad = partes[3];
                double tarifa = Double.parseDouble(partes[4]);
                int anos = Integer.parseInt(partes[5]);

                Consultor c;
                if (tipo.equals("SENIOR")) {
                    c = new ConsultorSenior(id, nombre, especialidad, tarifa, anos);
                } else {
                    c = new ConsultorJunior(id, nombre, especialidad, tarifa, anos);
                }

                consultoresPorId.put(c.getIdConsultor(), c);
                historialConsultores.add(c);
            }
            System.out.println("✅ " + historialConsultores.size() + " consultores cargados desde " + ARCHIVO_DATOS);
        } catch (IOException | NumberFormatException e) {
            System.err.println("ERROR al cargar los datos: " + e.getMessage());
        }
    }

    public void finalizarOperacion() {
        System.out.println("Bloque FINALLY: Tarea de limpieza completada");
    }
}