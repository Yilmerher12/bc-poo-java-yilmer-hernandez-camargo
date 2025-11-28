import java.util.ArrayList;

public class ProjectManager {

    private String consultancyName;
    private ArrayList<ConsultingProject> projectsList;

    public ProjectManager(String consultancyName) {
        this.consultancyName = consultancyName;
        // Inicializa la lista para que exista
        this.projectsList = new ArrayList<>();
    }

    // Metodo para agregar un objeto a la lista
    public void addProject(ConsultingProject newProject) {
        // Usa el metodo .add() para guardar el proyecto
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
            System.out.println(actualProject.getSummarizedInfo());
        }
    }

    // Metodo para retornar el numero de elementos
    public int countActiveProjects() {
        // Usa el metodo .size() para saber el total
        return this.projectsList.size();
    }
}