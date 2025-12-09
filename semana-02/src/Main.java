public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DEL SISTEMA DE CONSULTORÍA ===");

        //CREACIÓN DE OBJETOS BASE

        // Cliente 1
        Cliente clienteA = new Cliente("900001", "TechSolutions S.A.", "Contacto A", "Tecnologia", 1000.00);

        // Cliente 2
        Cliente clienteB = new Cliente("900002", "LogiCorp Ltda.", "Contacto B", "Logistica", 0.00);

        // Consultor 1
        Consultor consultorMKT = new Consultor("C001", "Ana Gómez", "Marketing", 50.00, 5);

        // Consultor 2
        Consultor consultorLOG = new Consultor("C002", "Juan Silva", "Logistica", 40.00, 3);

        //CREACIÓN DE PROYECTOS

        // Proyecto 1: Marketing (Asociado a clienteA y consultorMKT)
        ProyectoConsultoria proyecto1 = new ProyectoConsultoria("MKT-001", "Marketing", true, 20250115, 12000.00, clienteA, consultorMKT);

        // Proyecto 2: Logística (Asociado a clienteB y consultorLOG)
        ProyectoConsultoria proyecto2 = new ProyectoConsultoria("LOG-001", "Logistica", true, 20231001, 7500.50, clienteB, consultorLOG);


        //USO DE ARRAYLIST (Gestor de Proyectos)

        GestorProyectos gestorCentral = new GestorProyectos("Soluciones Estratégicas");

        // Agregar los proyectos a la lista
        gestorCentral.agregarProyecto(proyecto1);
        gestorCentral.agregarProyecto(proyecto2);

        System.out.println("\nTotal de proyectos en sistema: " + gestorCentral.contarProyectosActivos());
        gestorCentral.mostrarTodosLosProyectos();


        //DEMOSTRACIÓN DE RELACIONES Y MÉTODOS

        System.out.println("\n--- RELACIONES Y FACTURACIÓN ---");

        //Creación de Factura
        Facturacion factura1 = new Facturacion("FACT-001", 20250201, 12000.00, proyecto1.getCodigoProyecto(), clienteA);

        System.out.println("Estado cuenta Cliente A ANTES de pagar: $" + clienteA.getEstadoCuenta()); // Debe $1000

        factura1.mostrarEstadoFactura();

        // Demostrar el metodo de negocio de Cliente:
        System.out.println("¿Cliente A tiene deuda pendiente (antes de pagar)? " + clienteA.tieneDeudaPendiente());

        //Registrar Pago
        System.out.println("\nRegistrando pago de FACT-001...");
        factura1.registrarPago(); // Aquí, Facturacion le dice a Cliente: "Resta 12000 a tu saldo."

        //Verificar Saldos y Estado
        factura1.mostrarEstadoFactura(); // Debe mostrar PAGADA

        // El nuevo saldo de clienteA debe ser: 1000 (deuda anterior) - 12000 (pago de factura) = -11000 (saldo a favor)
        System.out.println("Estado cuenta Cliente A DESPUÉS de pagar: $" + clienteA.getEstadoCuenta());

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}