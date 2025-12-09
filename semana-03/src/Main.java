public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DEL SISTEMA (Final Semana 03) ===");

        // 1. CREACIÓN DE CLIENTES
        Cliente c1 = new Cliente("800123-4", "TechSolutions Inc.");
        Cliente c2 = new Cliente("900456-7", "Logistica Express", "Carlos Pérez", "Transporte");

        // 2. CREACIÓN DE CONSULTORES
        Consultor cons1 = new Consultor("C001", "Ana Gómez", "IT", 50.0);
        Consultor cons2 = new Consultor("C002", "Luis Torres", "Marketing", 40.0, 3);
        
        // 3. CREACIÓN DE PROYECTOS
        ProyectoConsultoria p1 = new ProyectoConsultoria("PROY-001", "Digitalización", c1, cons1);
        ProyectoConsultoria p2 = new ProyectoConsultoria("PROY-002", "Branding", c2);
        
        // 4. CREACIÓN DEL GESTOR
        GestorProyectos gestor = new GestorProyectos("Alpha Consultores");
        
        // 5. AGREGAR PROYECTOS AL GESTOR
        gestor.agregarProyecto(p1);
        gestor.agregarProyecto(p2);
        
        // 6. DEMOSTRACIÓN DE LÓGICA DE NEGOCIO Y ENCAPSULACIÓN
        
        System.out.println("\n--- Info Proyectos ---");
        p1.setPresupuestoProyecto(50000.0);
        System.out.println(p1.getInfoResumida());
        System.out.printf("Tarifa Diaria Estimada: $%.2f%n", p1.calcularTarifaDiaria());
        
        // 7. FACTURACIÓN
        Facturacion f1 = new Facturacion("F-00001", 20240301, 25000.0, p1.getCodigoProyecto(), c1);
        
        System.out.println("\n--- Estado de Cuenta ---");
        System.out.println(c1.getNombreEmpresa() + " | Deuda Inicial: $" + c1.getEstadoCuenta());
        
        // El cliente recibe la deuda
        c1.actualizarEstadoCuenta(f1.getMontoTotal());
        System.out.println(c1.getNombreEmpresa() + " | Deuda Tras Factura: $" + c1.getEstadoCuenta());
        
        // Se paga la factura, actualizando la cuenta del cliente
        f1.registrarPago();
        System.out.println(c1.getNombreEmpresa() + " | Deuda Final: $" + c1.getEstadoCuenta());
        
        // 8. DEMOSTRACIÓN DE GESTOR
        gestor.mostrarTodosLosProyectos();
    }
}