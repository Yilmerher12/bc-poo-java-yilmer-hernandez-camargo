public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DEL SISTEMA DE CONSULTORÍA ===");

        // --- 1. CREACIÓN DE OBJETOS BASE (Cliente y Consultor) ---

        // Cliente 1 (Con deuda de $1000.00 inicial)
        Cliente clienteA = new Cliente("900001", "TechSolutions S.A.", "Contacto A", "Tecnologia", 1000.00);

        // Cliente 2 (Sin deuda inicial)
        Cliente clienteB = new Cliente("900002", "LogiCorp Ltda.", "Contacto B", "Logistica", 0.00);

        // Consultor 1 (Especialista en Marketing)
        Consultor consultorMKT = new Consultor("C001", "Ana Gómez", "Marketing", 50.00, 5);

        // Consultor 2 (Especialista en Logística)
        Consultor consultorLOG = new Consultor("C002", "Juan Silva", "Logistica", 40.00, 3);

        // --- 2. CREACIÓN DE PROYECTOS (Objetos de ProyectoConsultoria) ---

        // Proyecto 1: Marketing (Asociado a clienteA y consultorMKT)
        ProyectoConsultoria proyecto1 = new ProyectoConsultoria("MKT-001", "Marketing", true, 20250115, 12000.00, clienteA, consultorMKT);

        // Proyecto 2: Logística (Asociado a clienteB y consultorLOG)
        ProyectoConsultoria proyecto2 = new ProyectoConsultoria("LOG-001", "Logistica", true, 20231001, 7500.50, clienteB, consultorLOG);


        // --- 3. USO DE ARRAYLIST (Gestor de Proyectos) ---

        GestorProyectos gestorCentral = new GestorProyectos ("Soluciones Estratégicas");

        gestorCentral.agregarProyecto(proyecto1);
        gestorCentral.agregarProyecto(proyecto2);

        System.out.println("\nTotal de proyectos en sistema: " + gestorCentral.contarProyectosActivos());
        gestorCentral.mostrarTodosLosProyectos();


        // --- 4. DEMOSTRACIÓN DE RELACIONES Y MÉTODOS DE NEGOCIO ---

        System.out.println("\n--- RELACIONES Y FACTURACIÓN ---");

        // 4.1. Creación de Factura (Asociada a proyecto1 y clienteA)
        // Nota: El saldo de clienteA ya es $1000
        Facturacion factura1 = new Facturacion("FACT-001", 20250201, 12000.00, proyecto1.obtenerCodigoProyecto(), clienteA);

        System.out.println("Estado cuenta Cliente A ANTES de pagar: $" + clienteA.obtenerEstadoCuenta()); // Debe $1000

        factura1.mostrarEstadoInvolucrado();

        // Demostrar el método de negocio de Cliente:
        System.out.println("¿Cliente A tiene deuda pendiente (antes de pagar)? " + clienteA.tieneDeudaPendiente());

        // 4.2. Registrar Pago (DEMUESTRA LA COMUNICACIÓN ENTRE OBJETOS)
        System.out.println("\nRegistrando pago de FACT-001...");
        factura1.registrarPago();

        // 4.3. Verificar Saldos y Estado
        factura1.mostrarEstadoInvolucrado();

        // El nuevo saldo de clienteA debe ser: 1000 (deuda anterior) - 12000 (pago de factura) = -11000 (saldo a favor)
        System.out.println("Estado cuenta Cliente A DESPUÉS de pagar: $" + clienteA.obtenerEstadoCuenta());

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}