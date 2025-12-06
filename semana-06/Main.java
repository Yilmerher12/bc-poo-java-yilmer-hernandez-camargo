
import java.util.ArrayList;
import java.util.List;

// Importar clases abstractas, concretas e interfaces para usarlas
import abstractas.Consultor;
import implementaciones.ConsultorSenior;
import implementaciones.ConsultorJunior;
import interfaces.Certificable;
import interfaces.Evaluable;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== CONSULTORÍA DE PROYECTOS: ABSTRACCIÓN Y CONTRATOS ===\n");

        // 1. Demostrar polimorfismo con clase abstracta
        System.out.println("--- Sección 1: Polimorfismo y Abstracción ---");

        // Creamos una lista de la clase abstracta Consultor para guardar las instancias
        List<Consultor> equipoConsultores = new ArrayList<>();

        // Crear objetos de las subclases concretas (Senior, Junior)
        ConsultorSenior seniorDevOps = new ConsultorSenior("CS001", "Ana Gómez", "DevOps", 120.0, 12);
        ConsultorJunior juniorBI = new ConsultorJunior("CJ005", "Luis Torres", "BI/Analytics", 80.0, 2);

        equipoConsultores.add(seniorDevOps);
        equipoConsultores.add(juniorBI);

        System.out.println("\n== Calculando Costos Polimórficos ==");
        double costoTotalEquipo = 0;

        // Recorremos la lista de tipo ABSTRACTO
        for (Consultor c : equipoConsultores) {
            // Llamamos a métodos abstractos sobrescritos
            c.mostrarInformacionBasica();
            System.out.println("Nivel/Descripción: " + c.obtenerDescripcion());

            double costo = c.calcularCostoMensualEstimado(160);
            System.out.printf("Costo (160h): $%.2f%n", costo);
            System.out.println("---------------------------------------------");
            costoTotalEquipo += costo;
        }
        System.out.printf("COSTO TOTAL MENSUAL DEL EQUIPO: $%.2f%n", costoTotalEquipo);

        // 2. Demostrar uso de interfaces
        System.out.println("\n--- Sección 2: Uso de Interfaces (Contratos) ---");


        Certificable cCertificable = seniorDevOps;

        System.out.println("== Gestión de Certificaciones ==");
        cCertificable.registrarCertificacion("AWS Solution Architect", 3);
        cCertificable.registrarCertificacion("Scrum Master PSM I", 5);

        System.out.println(cCertificable.listarCertificaciones());
        System.out.println("Vigencia AWS: " + cCertificable.verificarVigencia("AWS"));

        // 3. Demostrar múltiple implementación
        System.out.println("\n--- Sección 3: Múltiple Implementación y Polimorfismo de Interfaces ---");

        // Creamos referencias de tipo EVALUABLE
        Evaluable eSenior = seniorDevOps;
        Evaluable eJunior = juniorBI;

        System.out.println("== Evaluación del Equipo ==");

        // Evaluamos al Senior
        eSenior.agregarEvaluacion(4.5, "Experto en CI/CD.");
        eSenior.agregarEvaluacion(5.0, "Liderazgo en el proyecto X.");

        // Evaluamos al Junior
        eJunior.agregarEvaluacion(3.8, "Buen soporte inicial.");
        eJunior.agregarEvaluacion(4.0, "Necesita más autonomía.");

        System.out.printf("Senior %s (Promedio): %.2f%n",
                seniorDevOps.getNombreConsultor(), eSenior.obtenerPromedioEvaluacion());

        System.out.printf("Junior %s (Promedio): %.2f%n",
                juniorBI.getNombreConsultor(), eJunior.obtenerPromedioEvaluacion());

        System.out.println("Ana tiene evaluación superior a 4.5? " + eSenior.esEvaluacionSuperior(4.5));

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}