import java.util.ArrayList;

public class GestorProyectos {

    private String nombreConsultoria;
    private ArrayList<ProyectoConsultoria> listaProyectos;
    private ArrayList<Consultor> listaConsultores; // Necesario para Ejercicios 1 y 3

    // CONSTRUCTOR
    public GestorProyectos(String nombreConsultoria) {
        if (nombreConsultoria == null || nombreConsultoria.trim().isEmpty()) {
            throw new IllegalArgumentException("El gestor debe tener un nombre de consultoría asignado.");
        }
        this.nombreConsultoria = nombreConsultoria;
        this.listaProyectos = new ArrayList<>();
        this.listaConsultores = new ArrayList<>();
    }

    // --- MÉTODOS AUXILIARES Y BÁSICOS ---

    public void agregarProyecto(ProyectoConsultoria nuevoProyecto) {
        this.listaProyectos.add(nuevoProyecto);
        System.out.println("Proyecto '" + nuevoProyecto.getCodigoProyecto() + "' agregado al sistema.");
    }

    // Método auxiliar para agregar consultores (necesario para las búsquedas y el polimorfismo)
    public void agregarConsultor(Consultor nuevoConsultor) {
        this.listaConsultores.add(nuevoConsultor);
    }

    public String getNombreConsultoria() { return nombreConsultoria; }

    // =======================================================
    // EJERCICIO 1: SOBRECARGA DE MÉTODOS (OVERLOADING)
    // =======================================================

    // 1. Sobrecarga: Buscar consultor por ID (parámetro: String)
    public Consultor buscarConsultor(String id) {
        for (Consultor c : listaConsultores) {
            if (c.getIdConsultor().equals(id)) {
                return c;
            }
        }
        return null;
    }

    // 2. Sobrecarga: Buscar consultores por Especialidad (parámetros: String, boolean)
    public ArrayList<Consultor> buscarConsultor(String especialidad, boolean esEspecialidad) {
        ArrayList<Consultor> resultado = new ArrayList<>();
        for (Consultor c : listaConsultores) {
            if (c.getEspecialidadConsultor().equalsIgnoreCase(especialidad)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    // 3. Sobrecarga: Buscar consultores por Rango de Años (parámetros: int, int)
    public ArrayList<Consultor> buscarConsultor(int anosMinimos, int anosMaximos) {
        ArrayList<Consultor> resultado = new ArrayList<>();
        for (Consultor c : listaConsultores) {
            if (c.getAnosDeServicio() >= anosMinimos && c.getAnosDeServicio() <= anosMaximos) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    // =======================================================
    // EJERCICIO 3: MÉTODOS POLIMÓRFICOS (EXECUCIÓN)
    // =======================================================

    // Metodos poliformicos
    public void procesarFacturacion(Consultor consultor, int horasTrabajadas) {

        // Polimorfismo Dinámico: Llama a la versión Senior, Junior o Base de calcularCosto...
        double costo = consultor.calcularCostoMensualEstimado(horasTrabajadas);

        System.out.println("--- FACTURACIÓN ---");
        System.out.println("Consultor facturado: " + consultor.getNombreConsultor());
        System.out.println("Tipo real del objeto: " + consultor.getClass().getSimpleName());
        System.out.printf("Costo total para %d horas: $%.2f%n", horasTrabajadas, costo);
    }


    public void generarReporte(Consultor consultor) {

        // Polimorfismo Dinámico: Llama a la versión Senior, Junior o Base de obtenerDescripcion().
        String detalle = consultor.obtenerDescripcion();

        System.out.println("\n--- REPORTE DE CONSULTOR ---");
        System.out.println(detalle);
        System.out.println("----------------------------");
    }
}