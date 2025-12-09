public class Main {
    public static void main (String[] args){
        System.out.println("\n--- GESTIÓN DE CONSULTORÍA Y FACTURACIÓN ---");

        System.out.println("\n1. Creación de Objetos");

        // Primer Proyecto (Marketing)
        ProyectoConsultoria primerProyecto = new ProyectoConsultoria("MKT-001", "Marketing Digital", true, 2025, 12000.00);

        // Segundo Proyecto (Logística)
        ProyectoConsultoria segundoProyecto = new ProyectoConsultoria("LOG-001", "Optimización Logística", true, 2023, 7500.50);

        // Primera y Segunda Factura (Usa el código del proyecto como relación)
        Facturacion primeraFactura = new Facturacion("FACT-001", 20250201, primerProyecto.getPresupuestoProyecto(), primerProyecto.getCodigoProyecto(), false);
        Facturacion segundaFactura = new Facturacion("FACT-002", 20231215, segundoProyecto.getPresupuestoProyecto(), segundoProyecto.getCodigoProyecto(), true);


        System.out.println("\n2. Demostración de Métodos y Funcionalidades");

        // --- DEMOSTRACIÓN PROYECTO 1 ---
        System.out.println("\n--- Proyecto MKT-001 ---");
        primerProyecto.mostrarInformacionProyecto();

        double tarifaP1 = primerProyecto.calcularTarifaDiariaEstimada();
        System.out.println("Tarifa diaria estimada: $" + tarifaP1);

        System.out.println("Código del proyecto (Getter): " + primerProyecto.getCodigoProyecto());

        primerProyecto.setPresupuestoProyecto(15000.00);


        // --- DEMOSTRACIÓN FACTURA 1 ---
        System.out.println("\n--- Factura FACT-001 ---");
        primeraFactura.mostrarEstadoFactura();

        double impuestosF1 = primeraFactura.calcularImpuestos(0.19);
        System.out.println("Impuestos a pagar (19%): $" + impuestosF1);

        primeraFactura.registrarPago();

        // Muestra el cambio de estado
        System.out.println("\n--- Estado de FACT-001 después del pago ---");
        primeraFactura.mostrarEstadoFactura();

        // Intenta pagar de nuevo (demostración de la lógica de negocio)
        primeraFactura.registrarPago();


        // --- DEMOSTRACIÓN FACTURA 2 ---
        System.out.println("\n--- Factura FACT-002 (Ya pagada) ---");
        segundaFactura.mostrarEstadoFactura();
        double impuestosF2 = segundaFactura.calcularImpuestos(0.10);
        System.out.println("Impuestos a pagar (10%): $" + impuestosF2);


        System.out.println("\n3. Resumen de Montos Totales (Getters)");
        System.out.println("Monto total Factura 1 (con nuevo presupuesto): $" + primeraFactura.getMontoTotal());
        System.out.println("Monto total Factura 2: $" + segundaFactura.getMontoTotal());
    }
}
