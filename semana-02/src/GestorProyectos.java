import java.util.ArrayList;

public class GestorProyectos {

    private String nombreConsultora;
    private ArrayList<ProyectoConsultoria> listaProyectos;

    public GestorProyectos(String nombreConsultora) {
        this.nombreConsultora = nombreConsultora;
        // Inicializa la lista para que exista
        this.listaProyectos = new ArrayList<>();
    }

    // Metodo para agregar un objeto a la lista
    public void agregarProyecto(ProyectoConsultoria nuevoProyecto) {
        // Usa el metodo .add() para guardar el proyecto
        this.listaProyectos.add(nuevoProyecto);
        System.out.println("Proyecto '" + nuevoProyecto.getCodigoProyecto() + "' agregado al sistema.");
    }

    // Metodo para mostrar todos los elementos (usando bucle tradicional)
    public void mostrarTodosLosProyectos() {
        System.out.println("\n=== Proyectos activos de " + this.nombreConsultora + " ===");

        // Obtenemos cuántos elementos hay
        int cantidad = this.listaProyectos.size();

        // Recorremos la lista usando índices (i)
        for (int i = 0; i < cantidad; i++) {
            // Usamos .get(i) para obtener el objeto en esa posicion
            ProyectoConsultoria proyectoActual = this.listaProyectos.get(i);

            // Llamamos a un metodo del objeto Proyecto para imprimir su resumen
            System.out.println(proyectoActual.getInformacionResumida());
        }
    }

    // Metodo para retornar el numero de elementos
    public int contarProyectosActivos() {
        // Usa el metodo .size() para saber el total
        return this.listaProyectos.size();
    }
}