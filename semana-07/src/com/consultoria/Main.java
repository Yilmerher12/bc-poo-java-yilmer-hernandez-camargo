package com.consultoria;

// Importar clases de otros paquetes
import com.consultoria.modelo.ConsultorSenior;
import com.consultoria.modelo.ConsultorJunior;
import com.consultoria.servicio.GestorConsultores;
import com.consultoria.excepciones.ContratoInvalidoException;
import com.consultoria.excepciones.CapacidadAgotadaException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CONSULTORÍA DE PROYECTOS: MANEJO DE EXCEPCIONES ===\n");

        // Inicialización
        GestorConsultores gestor = new GestorConsultores();

        // --- Objetos de prueba (5 ARGUMENTOS CADA UNO) ---
        // Válido: ID de 5 caracteres
        ConsultorSenior senior1 = new ConsultorSenior("A1001", "Ana Gómez", "DevOps", 80.0, 10);
        ConsultorSenior senior2 = new ConsultorSenior("B2002", "Carlos Ruiz", "Cloud", 95.0, 12);
        // Inválido: ID de 3 caracteres (regla: 5)
        ConsultorJunior juniorInvalido = new ConsultorJunior("100", "Beto Pérez", "Backend", 50.0, 2);

        // 1. Caso de Prueba: Éxito  (El try funciona)
        System.out.println("--- Caso 1/5: Contrato Válido ---");
        try {
            gestor.agregarConsultor(senior1);
        } catch (ContratoInvalidoException | CapacidadAgotadaException e) {
            System.err.println("ERROR INESPERADO: " + e.getMessage());
        }

        // 2. Caso de Prueba: Éxito (Usa el último cupo) ✅
        System.out.println("\n--- Caso 2/5: Agrega el último consultor (Límite 2) ---");
        try {
            gestor.agregarConsultor(senior2);
        } catch (ContratoInvalidoException | CapacidadAgotadaException e) {
            System.err.println("ERROR INESPERADO: No debería fallar aquí. " + e.getMessage());
        }

        // 3. Caso de Prueba: Capacidad Agotada  (Excepción Personalizada 1)
        System.out.println("\n--- Caso 3/5: Límite de Capacidad ---");
        try {
            // Intentar agregar un tercero cuando el límite es 2
            gestor.agregarConsultor(new ConsultorJunior("C3003", "Diana Solis", "Data", 45.0, 1));
        } catch (ContratoInvalidoException e) {
            System.err.println("Fallo Capturado (Contrato Inválido): " + e.getMessage());
        } catch (CapacidadAgotadaException e) {
            // Este catch atrapa la alerta y evita que el programa se cierre.
            System.err.println("Fallo Capturado (Capacidad Agotada): " + e.getMessage());
        }

        // 4. Caso de Prueba: Contrato Inválido  (Excepción Personalizada 2)
        System.out.println("\n--- Caso 4/5: ID Incorrecto (Lanza ContratoInvalidoException) ---");
        try {
            gestor.agregarConsultor(juniorInvalido);
        } catch (ContratoInvalidoException e) {
            System.err.println("Fallo Capturado (Contrato Inválido): " + e.getMessage());
        } catch (CapacidadAgotadaException e) {
            System.err.println("Fallo Capturado (Capacidad Agotada): " + e.getMessage());
        }

        // 5. Caso de Prueba: Demostración de 'finally' y Objeto Nulo
        System.out.println("\n--- Caso 5/5: Objeto Nulo y Uso de FINALLY ---");
        try {
            gestor.agregarConsultor(null); // Lanza ContratoInvalidoException por ser nulo
        } catch (ContratoInvalidoException e) {
            System.err.println("Fallo Capturado (Objeto Nulo): " + e.getMessage());
        } catch (CapacidadAgotadaException e) {
            System.err.println("Fallo Capturado: " + e.getMessage());
        } finally {
            // El bloque finally siempre se ejecuta, haya error o no.
            gestor.finalizarOperacion();
        }

        System.out.println("\n=== PRUEBAS DE LA SEMANA 07 COMPLETADAS ===");
    }
}