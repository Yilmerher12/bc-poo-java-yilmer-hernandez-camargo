//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // First Object: Strategic Management
        ConsultingProject project1 = new ConsultingProject("TEC-001", "Auditoría de Ciberseguridad", 1200);

        // Second Object: Human Resources
        ConsultingProject project2 = new ConsultingProject("RHM-005", "Análisis de Clima Laboral", 1000);

        // Third Object: Finance
        ConsultingProject project3 = new ConsultingProject("FIN-010", "Estructuración de Deuda", 1600);

        // Fourth Object: Marketing
        ConsultingProject project4 = new ConsultingProject("MKT-007", "Estrategia de Contenido Digital", 1750);

        // Fifth Object: Logistics
        ConsultingProject project5 = new ConsultingProject("LOG-002", "Optimización de Rutas de Distribución", 2400);

        //Showing data in the console
            System.out.println("\n------------First Project------------");
                project1.ShowProjectInfo();
            System.out.println("\n------------Second Project------------");
                project2.ShowProjectInfo();
            System.out.println("\n------------Third Project------------");
                project3.ShowProjectInfo();
            System.out.println("\n------------Fourth Project------------");
                project4.ShowProjectInfo();
            System.out.println("\n------------Fifth Project------------");
                project5.ShowProjectInfo();

    }
}