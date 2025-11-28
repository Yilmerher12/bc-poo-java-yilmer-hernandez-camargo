//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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

        // --- 2. CREACIÓN DE PROYECTOS (Objetos de ConsultingProject) ---

        // Proyecto 1: Marketing (Asociado a clienteA y consultorMKT)
        ConsultingProject project1 = new ConsultingProject("MKT-001", "Marketing", true, 20250115, 12000.00, clienteA, consultorMKT);

        // Proyecto 2: Logística (Asociado a clienteB y consultorLOG)
        ConsultingProject project2 = new ConsultingProject("LOG-001", "Logistic", true, 20231001, 7500.50, clienteB, consultorLOG);


        // --- 3. USO DE ARRAYLIST (Gestor de Proyectos) ---

        ProjectManager gestorCentral = new ProjectManager ("Soluciones Estratégicas");

        // Agregar los proyectos a la lista
        gestorCentral.addProject(project1);
        gestorCentral.addProject(project2);

        System.out.println("\nTotal de proyectos en sistema: " + gestorCentral.countActiveProjects());
        gestorCentral.showAllProjects();


        // --- 4. DEMOSTRACIÓN DE RELACIONES Y MÉTODOS DE NEGOCIO ---

        System.out.println("\n--- RELACIONES Y FACTURACIÓN ---");

        // 4.1. Creación de Factura (Asociada a project1 y clienteA)
        // Nota: El saldo de clienteA ya es $1000
        Billing bill1 = new Billing("FACT-001", 20250201, 12000.00, project1.getProjectCode(), clienteA);

        System.out.println("Estado cuenta Cliente A ANTES de pagar: $" + clienteA.getAccountStatus()); // Debe $1000

        bill1.showInvolveStatus();

        // Demostrar el método de negocio de Cliente:
        System.out.println("¿Cliente A tiene deuda pendiente (antes de pagar)? " + clienteA.hasAPendingDebt());

        // 4.2. Registrar Pago (DEMUESTRA LA COMUNICACIÓN ENTRE OBJETOS)
        System.out.println("\nRegistrando pago de FACT-001...");
        bill1.registerPayment(); // Aquí, Facturacion le dice a Cliente: "Resta 12000 a tu saldo."

        // 4.3. Verificar Saldos y Estado
        bill1.showInvolveStatus(); // Debe mostrar PAGADA

        // El nuevo saldo de clienteA debe ser: 1000 (deuda anterior) - 12000 (pago de factura) = -11000 (saldo a favor)
        System.out.println("Estado cuenta Cliente A DESPUÉS de pagar: $" + clienteA.getAccountStatus());

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}