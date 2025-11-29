import java.util.ArrayList;

public class ProjectManager {

    private String consultancyName;
    private ArrayList<ConsultingProject> projectsList;

    // CONSTRUCTOR 1 (PRINCIPAL / COMPLETO): Recibe el nombre de la consultora.
    public ProjectManager(String consultancyName) {
        // Validación mínima: el nombre no puede ser nulo o vacío
        if (consultancyName == null || consultancyName.trim().isEmpty()) {
            throw new IllegalArgumentException("El gestor debe tener un nombre de consultoría asignado.");
        }
        this.consultancyName = consultancyName;
        // La lista se inicializa siempre
        this.projectsList = new ArrayList<>();
    }

    // CONSTRUCTOR 2 (POR DEFECTO): No recibe nombre y asigna un nombre genérico.
    public ProjectManager() {
        // Llama al Constructor 1, asignando un nombre por defecto.
        this("Consultoría Global");
    }

    // --- MÉTODOS DE LA CLASE ---
    public void addProject(ConsultingProject newProject) {
        this.projectsList.add(newProject);
        System.out.println("Proyecto '" + newProject.getProjectCode() + "' agregado al sistema.");
    }

    // Metodo para mostrar todos los elementos (usando bucle tradicional)
    public void showAllProjects() {
        System.out.println("\n=== Active projects of " + this.consultancyName + " ===");

        // Obtenemos cuántos elementos hay
        int quantity = this.projectsList.size();

        // Recorremos la lista usando índices (i)
        for (int i = 0; i < quantity; i++) {
            // Usamos .get(i) para obtener el objeto en esa posicion
            ConsultingProject actualProject = this.projectsList.get(i);

            // Llamamos a un metodo del objeto Proyecto para imprimir su resumen
            System.out.println(actualProject.obtenerInformacionResumida());
        }
    }

    // Metodo para retornar el numero de elementos
    public int countActiveProjects() {
        // Usa el metodo .size() para saber el total
        return this.projectsList.size();
    }
}