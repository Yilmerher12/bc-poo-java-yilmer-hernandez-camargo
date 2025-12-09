public class ProyectoConsultoria {

    // Atributos (camelCase en español)
    private String codigoProyecto;
    protected String areaProyecto;
    protected boolean estaActivo;
    protected int anioInicioProyecto;
    private double presupuestoProyecto;

    // Constructor
    public ProyectoConsultoria(String codigoProyecto, String areaProyecto, boolean estaActivo, int anioInicioProyecto, double presupuestoProyecto) {
        this.codigoProyecto = codigoProyecto;
        this.areaProyecto = areaProyecto;
        this.estaActivo = estaActivo;
        this.presupuestoProyecto = presupuestoProyecto;
        this.anioInicioProyecto = anioInicioProyecto;
    }

    // Metodo void (imprime información)
    public void mostrarInformacionProyecto() {
        System.out.println("--- Proyecto POO ---");
        System.out.println("Código del proyecto: " + this.codigoProyecto);
        System.out.println("Área del proyecto: " + this.areaProyecto);
        System.out.println("Presupuesto del proyecto: $" + this.presupuestoProyecto);
        System.out.println("¿Está activo?: " + (this.estaActivo ? "SÍ" : "NO"));
        System.out.println("Año de inicio: " + this.anioInicioProyecto);
    }

    // Metodo que retorna valor calculado
    public double calcularTarifaDiariaEstimada() {
        // Constante (UPPER_SNAKE_CASE)
        final int DIAS_HABITUALES_PROYECTO = 120;
        return this.presupuestoProyecto / DIAS_HABITUALES_PROYECTO;
    }

    // Getter (mínimo 1)
    public String getCodigoProyecto() {
        return codigoProyecto;
    }

    public double getPresupuestoProyecto() {
        return presupuestoProyecto;
    }

    // Setter (mínimo 1)
    public void setPresupuestoProyecto(double presupuestoProyecto) {
        if (presupuestoProyecto > 0) {
            this.presupuestoProyecto = presupuestoProyecto;
            System.out.println("Presupuesto actualizado a: $" + this.presupuestoProyecto);
        } else {
            System.out.println("Error: El presupuesto debe ser un valor positivo.");
        }
    }
}