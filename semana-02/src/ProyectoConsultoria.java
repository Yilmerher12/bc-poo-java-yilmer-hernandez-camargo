public class ProyectoConsultoria {

    private Cliente clientePrincipal;
    private Consultor consultorAsignado;
    private String codigoProyecto;
    protected String areaProyecto; // Usamos protected (como estaba en el original)
    protected boolean estaActivo; // Usamos protected (como estaba en el original)
    protected int anioInicioProyecto; // Usamos protected (como estaba en el original)
    private double presupuestoProyecto;

    public ProyectoConsultoria(String codigoProyecto, String areaProyecto, boolean estaActivo, int anioInicioProyecto, double presupuestoProyecto, Cliente clientePrincipal, Consultor consultorAsignado) {
        this.codigoProyecto = codigoProyecto;
        this.areaProyecto = areaProyecto;
        this.estaActivo = estaActivo;
        this.anioInicioProyecto = anioInicioProyecto;
        this.presupuestoProyecto = presupuestoProyecto;
        this.clientePrincipal = clientePrincipal;
        this.consultorAsignado = consultorAsignado;
    }

    public String getInformacionResumida() {
        return "Código Proyecto: " + this.codigoProyecto +
                " | Área: " + this.areaProyecto +
                " | Cliente: " + this.clientePrincipal.getNombreEmpresa() +
                " | Consultor: " + this.consultorAsignado.getNombreConsultor();
    }

    public void mostrarInformacionProyecto() {
        System.out.println("--- Proyecto POO ---");
        System.out.println("Código del Proyecto: " + this.codigoProyecto);
        System.out.println("Área del Proyecto: " + this.areaProyecto);
        System.out.println("Presupuesto del Proyecto: $" + this.presupuestoProyecto);
        System.out.println("¿El proyecto está activo?: " + this.estaActivo);
        System.out.println("Año de Inicio del Proyecto: " + this.anioInicioProyecto);
    }

    public double calcularTarifaFinal() {
        // Constante de ejemplo sobre los días del proyecto
        final int DIAS_PROYECTO_HABITUALES = 120;
        return this.presupuestoProyecto / DIAS_PROYECTO_HABITUALES;
    }

    // Getter para el codigoProyecto
    public String getCodigoProyecto() {
        return codigoProyecto;
    }

    // Getter y Setter para el presupuestoProyecto
    public double getPresupuestoProyecto() {
        return presupuestoProyecto;
    }

    public void setPresupuestoProyecto(double presupuestoProyecto) {
        if (presupuestoProyecto > 0) {
            this.presupuestoProyecto = presupuestoProyecto;
        } else {
            System.out.println("Error: El presupuesto debe ser un valor positivo.");
        }
    }
}