package com.consultoria;

import com.consultoria.modelo.ConsultorSenior;
import com.consultoria.modelo.ConsultorJunior;
import com.consultoria.modelo.Consultor;
import com.consultoria.servicio.GestorConsultores;
import com.consultoria.excepciones.ContratoInvalidoException;
import com.consultoria.excepciones.CapacidadAgotadaException;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final GestorConsultores gestor = new GestorConsultores();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Carga de datos al iniciar (Semana 09 - Persistencia)
        gestor.cargarConsultores();

        // Inicialización de datos de ejemplo si no hay archivo de persistencia
        if (gestor.cantidad() == 0) {
            inicializarDatosEjemplo();
        }

        int opcion;
        do {
            mostrarMenu();
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1: agregarNuevoConsultor(); break;
                    case 2: buscarPorId(); break;
                    case 3: eliminarConsultor(); break;
                    case 4: listarTodos(); break;
                    case 5: filtrarSeniorPorAntiguedad(); break;
                    case 6: mostrarEstadisticas(); break;
                    case 0:
                        System.out.println("✅ Saliendo del sistema de consultoría. Guardando datos...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (java.util.InputMismatchException e) {
                System.err.println("ERROR: Ingrese solo números para la opción.");
                scanner.nextLine();
                opcion = -1;
            } catch (Exception e) {
                System.err.println("ERROR: " + e.getMessage());
                opcion = -1;
            }

        } while (opcion != 0);

        // Guardado de datos antes de salir (Semana 09 - Persistencia)
        gestor.guardarConsultores();
        gestor.finalizarOperacion();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE CONSULTORES (PROYECTO FINAL) ===");
        System.out.println("1. Agregar nuevo consultor");
        System.out.println("2. Buscar consultor por ID (Búsqueda Rápida O(1))");
        System.out.println("3. Eliminar consultor por ID");
        System.out.println("4. Listar todos los consultores");
        System.out.println("--- Operaciones Avanzadas (Ejer. 3) ---");
        System.out.println("5. Filtrar Senior por Años de Servicio");
        System.out.println("6. Mostrar Estadísticas y Conteo");
        System.out.println("0. Salir (Guarda los datos)");
        System.out.print("Seleccione una opción: ");
    }

    private static void inicializarDatosEjemplo() {
        System.out.println("⚙️ Cargando datos de ejemplo iniciales...");
        try {
            // Se usan 5 argumentos: ID, Nombre, Especialidad, Tarifa, Años
            gestor.agregarConsultor(new ConsultorSenior("A1001", "Ana Gómez", "DevOps", 80.0, 10));
            gestor.agregarConsultor(new ConsultorJunior("B2002", "Beto Pérez", "Backend", 50.0, 2));
            gestor.agregarConsultor(new ConsultorSenior("C3003", "Carlos Ruiz", "Cloud", 95.0, 12));
            gestor.agregarConsultor(new ConsultorJunior("D4004", "Diana Solis", "Backend", 55.0, 3));
        } catch (ContratoInvalidoException | CapacidadAgotadaException e) {
            System.err.println("Error al inicializar datos: " + e.getMessage());
        }
    }

    private static void agregarNuevoConsultor() {
        try {
            System.out.println("\n--- Agregar Nuevo Consultor ---");
            System.out.print("ID (5 caracteres): ");
            String id = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Especialidad: ");
            String esp = scanner.nextLine();
            System.out.print("Tarifa por hora: ");
            double tarifa = scanner.nextDouble();
            System.out.print("Años de servicio: ");
            int anos = scanner.nextInt();
            scanner.nextLine();

            Consultor nuevo = new ConsultorSenior(id, nombre, esp, tarifa, anos);
            gestor.agregarConsultor(nuevo);

        } catch (ContratoInvalidoException | CapacidadAgotadaException e) {
            System.err.println("❌ ERROR DE CONTRATO/CAPACIDAD: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ ERROR: Entrada inválida.");
            scanner.nextLine();
        }
    }

    private static void buscarPorId() {
        System.out.print("Ingrese el ID del consultor a buscar (5 caracteres): ");
        String id = scanner.nextLine();

        Consultor c = gestor.buscarPorId(id);

        if (c != null) {
            System.out.println("\n✅ Consultor Encontrado:");
            System.out.println("- Nombre: " + c.getNombreConsultor());
            System.out.println("- Descripción: " + c.obtenerDescripcion());
            System.out.println("- Costo Mensual Estimado (160h): $" + c.calcularCostoMensualEstimado(160));
        } else {
            System.out.println("|ERROR| Consultor con ID " + id + " no encontrado.");
        }
    }

    private static void eliminarConsultor() {
        System.out.print("Ingrese el ID del consultor a eliminar: ");
        String id = scanner.nextLine();

        Consultor c = gestor.eliminarConsultor(id);

        if (c == null) {
            System.out.println("|ERROR| No se encontró el consultor con ID " + id);
        }
    }

    private static void listarTodos() {
        List<Consultor> lista = gestor.obtenerTodos();
        if (lista.isEmpty()) {
            System.out.println("La lista de consultores está vacía.");
            return;
        }
        System.out.println("\n=== LISTA COMPLETA DE CONSULTORES (" + lista.size() + ") ===");
        for (Consultor c : lista) {
            System.out.println("- ID: " + c.getIdConsultor() + " | Nombre: " + c.getNombreConsultor() + " | " + c.obtenerDescripcion());
        }
    }

    private static void filtrarSeniorPorAntiguedad() {
        try {
            System.out.print("Ingrese años mínimos de servicio para Senior: ");
            int anosMinimos = scanner.nextInt();
            scanner.nextLine();

            List<Consultor> filtrados = gestor.filtrarSeniorPorAnos(anosMinimos);

            if (filtrados.isEmpty()) {
                System.out.println("No se encontraron Consultores Senior con esa antigüedad.");
                return;
            }

            System.out.println("\n=== CONSULTOR SENIOR (Antigüedad >=" + anosMinimos + " años) ===");
            for (Consultor c : filtrados) {
                System.out.println("- ID: " + c.getIdConsultor() + " | Nombre: " + c.getNombreConsultor() + " | Antigüedad: " + c.getAnosDeServicio());
            }
        } catch (java.util.InputMismatchException e) {
            System.err.println("ERROR: Debe ingresar un número entero para los años mínimos.");
            scanner.nextLine();
        }
    }

    private static void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS GENERALES ===");
        int horas = 160;

        int cantidad = gestor.cantidad();
        if (cantidad == 0) {
            System.out.println("No hay consultores para calcular estadísticas.");
            return;
        }

        double totalCosto = gestor.calcularCostoTotalMensual(horas);
        System.out.println("Total de Consultores: " + cantidad);
        System.out.printf("Costo Total Estimado Mensual (%d horas): $%,.2f%n", horas, totalCosto);
        System.out.printf("Costo Promedio por Consultor: $%,.2f%n", totalCosto / cantidad);

        System.out.println("\n--- Conteo por Especialidad ---");
        Map<String, Integer> conteo = gestor.contarPorEspecialidad();
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            System.out.println("  - " + entry.getKey() + ": " + entry.getValue() + " consultores");
        }
    }
}