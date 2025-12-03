import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Se instancia usando las clases hijas de consultor

        ConsultorSenior senior1 = new ConsultorSenior("CS001", "Ana García", "Backend", 65.0, 8 // 8 años
        );

        ConsultorJunior junior1 = new ConsultorJunior("CJ002", "Luis Pérez", "Frontend", 50.0, 1 // 1 año
        );

        ConsultorSenior senior2 = new ConsultorSenior("CS003", "Maria López", "Cloud", 70.0, 15 // 15 años
        );

        // 2. CREACIÓN DEL GESTOR E INSERCIÓN
        GestorProyectos gestor = new GestorProyectos("TechConsulting Latam");
        gestor.agregarConsultor(senior1);
        gestor.agregarConsultor(junior1);
        gestor.agregarConsultor(senior2);


        System.out.println("\n--- 1. DEMOSTRACIÓN DE EJECUCIÓN POLIMÓRFICA (GestorProyectos) ---");

        gestor.procesarFacturacion(senior1, 160); // Senior usa Costo con Bono
        gestor.procesarFacturacion(junior1, 160); // Junior usa Costo con Tarifa Fija

        gestor.generarReporte(senior2);
        gestor.generarReporte(junior1);


        System.out.println("\n--- 2. DEMOSTRACIÓN DE ARRAYLIST POLIMÓRFICO ---");

        // ArrayList almacena el tipo Padre (Consultor), pero contiene objetos Hijos.
        ArrayList<Consultor> equipo = new ArrayList<>();
        equipo.add(senior1);
        equipo.add(junior1);
        equipo.add(senior2);

        double costoTotal = 0;

        System.out.println("\n== RECORRIENDO EL EQUIPO CON BUCLE ÚNICO ==");
        for (Consultor c : equipo) {
            // dynamic binding: La llamada a obtenerDescripcion() se resuelve en tiempo de ejecución
            System.out.println("Descripción: " + c.obtenerDescripcion());

            // dynamic binding: La llamada a calcularCosto... se resuelve en tiempo de ejecución
            double costo = c.calcularCostoMensualEstimado(100);
            System.out.printf("Costo (100h): $%.2f%n", costo);
            System.out.println("---------------------------------------------");
            costoTotal += costo;
        }
        System.out.printf("COSTO TOTAL ESTIMADO DEL EQUIPO: $%.2f%n", costoTotal);



        System.out.println("\n--- 3. DEMOSTRACIÓN DE SOBRECARGA (GestorProyectos) ---");

        // 1. Buscar por ID (String)
        Consultor cID = gestor.buscarConsultor("CS001");
        System.out.println("Búsqueda 1 (ID CS001): " + (cID != null ? cID.getNombreConsultor() : "No encontrado"));

        // 2. Buscar por Rango de Años (int, int)
        ArrayList<Consultor> cRango = gestor.buscarConsultor(10, 20); // 10 a 20 años
        System.out.println("Búsqueda 2 (Antigüedad 10+ años): " + cRango.size() + " consultor(es) encontrado(s).");
    }
}