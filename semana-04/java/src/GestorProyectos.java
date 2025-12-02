import java.util.ArrayList;

public class GestorProyectos {

    private String nombreConsultoria;
    private ArrayList<ProyectoConsultoria> listaProyectos;

    // CONSTRUCTOR 1 (PRINCIPAL / COMPLETO)
    public GestorProyectos(String nombreConsultoria) {
        if (nombreConsultoria == null || nombreConsultoria.trim().isEmpty()) {
            throw new IllegalArgumentException("El gestor debe tener un nombre de consultoría asignado.");
        }
        this.nombreConsultoria = nombreConsultoria;
        this.listaProyectos = new ArrayList<>();
    }

    // CONSTRUCTOR 2 (POR DEFECTO)
    public GestorProyectos() {
        // Llama al Constructor 1, asignando un nombre por defecto.
        this("Consultoría Global");
    }

    // MÉTODOS DE LA CLASE
    public void agregarProyecto(ProyectoConsultoria nuevoProyecto) {
        this.listaProyectos.add(nuevoProyecto);
        System.out.println("Proyecto '" + nuevoProyecto.obtenerCodigoProyecto() + "' agregado al sistema.");
    }

    public void mostrarTodosLosProyectos() {
        System.out.println("\n=== Proyectos Activos de " + this.nombreConsultoria + " ===");

        int cantidad = this.listaProyectos.size();

        for (int i = 0; i < cantidad; i++) {
            ProyectoConsultoria proyectoActual = this.listaProyectos.get(i);
            System.out.println(proyectoActual.obtenerInfoResumida());
        }
    }

    public int contarProyectosActivos() {
        return this.listaProyectos.size();
    }
}