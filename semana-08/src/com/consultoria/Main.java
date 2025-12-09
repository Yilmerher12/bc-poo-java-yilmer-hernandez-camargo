package com.consultoria;

// Importaciones necesarias
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
        inicializarDatos();

        int opcion;
        do {
            mostrarMenu();
            // Manejo de errores básicos al leer la opción
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1: agregarNuevoConsultor(); break;
                    case 2: buscarPorId(); break;      // Demuestra HashMap O(1)
                    case 3: eliminarConsultor(); break;
                    case 4: listarTodos(); break;      // Demuestra ArrayList
                    case 5: filtrarSeniorPorAntiguedad(); break; // Demuestra Filtrado (Ejer. 3)
                    case 6: mostrarEstadisticas(); break; // Demuestra Estadísticas (Ejer. 3)
                    case 0:
                        System.out.println("Saliendo del sistema de consultoría.");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (java.util.InputMismatchException e) {
                System.err.println("ERROR: Ingrese solo números para la opción.");
                scanner.nextLine(); // Limpiar buffer para evitar bucle infinito
                opcion = -1; // Fuerza a repetir el menú
            } catch (Exception e) {
                System.err.println("ERROR: " + e.getMessage());
                opcion = -1;
            }

        } while (opcion != 0);

        gestor.finalizarOperacion();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE CONSULTORES (SEMANA 08) ===");
        System.out.println("1. Agregar nuevo consultor");
        System.out.println("2. Buscar consultor por ID (Búsqueda Rápida O(1))");
        System.out.println("3. Eliminar consultor por ID");
        System.out.println("4. Listar todos los consultores");
        System.out.println("--- Ejercicio 3: Filtrado y Estadísticas ---");
        System.out.println("5. Filtrar Senior por Años de Servicio");
        System.out.println("6. Mostrar Estadísticas y Conteo");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void inicializarDatos() {
        // Inicialización con 5 argumentos (ConsultorSenior/Junior constructor)
        try {
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
            System.out.println("\n--- Agregar Nuevo Consultor (Senior por defecto) ---");
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

            // Creamos un Senior
            Consultor nuevo = new ConsultorSenior(id, nombre, esp, tarifa, anos);
            gestor.agregarConsultor(nuevo);

        } catch (ContratoInvalidoException | CapacidadAgotadaException e) {
            System.err.println("ERROR DE CONTRATO/CAPACIDAD: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("ERROR: Entrada inválida. Asegúrese de ingresar números para Tarifa/Años.");
            scanner.nextLine();
        }
    }

    private static void buscarPorId() {
        System.out.print("Ingrese el ID del consultor a buscar (5 caracteres): ");
        String id = scanner.nextLine();

        // USO DE HASHMAP O(1)
        Consultor c = gestor.buscarPorId(id);

        if (c != null) {
            System.out.println("\nConsultor Encontrado (Búsqueda O(1)):");
            System.out.println("- Nombre: " + c.getNombreConsultor());
            System.out.println("- Descripción: " + c.obtenerDescripcion());
            System.out.println("- Costo Mensual Estimado (160h): $" + c.calcularCostoMensualEstimado(160));
        } else {
            System.out.println("Consultor con ID " + id + " no encontrado.");
        }
    }

    private static void eliminarConsultor() {
        System.out.print("Ingrese el ID del consultor a eliminar: ");
        String id = scanner.nextLine();

        Consultor c = gestor.eliminarConsultor(id);

        if (c == null) {
            System.out.println("No se encontró el consultor con ID " + id);
        }
    }

    private static void listarTodos() {
        List<Consultor> lista = gestor.obtenerTodos(); // USO DE ARRAYLIST
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
    }

    private static void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS GENERALES ===");
        int horas = 160;

        // Total y Promedio
        double totalCosto = gestor.calcularCostoTotalMensual(horas);
        System.out.println("Total de Consultores: " + gestor.cantidad());
        System.out.printf("Costo Total Estimado Mensual (%d horas): $%,.2f%n", horas, totalCosto);
        System.out.printf("Costo Promedio por Consultor: $%,.2f%n", totalCosto / gestor.cantidad());

        // Conteo por Especialidad (Uso de HashMap auxiliar)
        System.out.println("\n--- Conteo por Especialidad ---");
        Map<String, Integer> conteo = gestor.contarPorEspecialidad();
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            System.out.println("  - " + entry.getKey() + ": " + entry.getValue() + " consultores");
        }
    }
}