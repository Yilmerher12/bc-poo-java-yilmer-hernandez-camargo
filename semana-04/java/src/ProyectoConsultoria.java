public class ProyectoConsultoria {

    // 1. ATRIBUTOS PRIVATE
    private Cliente clientePrincipal; // Composición
    private Consultor consultorAsignado; // Composición
    private String codigoProyecto;
    private String areaProyecto;
    private boolean estaActivo;
    private int fechaInicioProyecto;
    private double presupuestoProyecto;

    // CONSTRUCTOR 1 (PRINCIPAL / COMPLETO)
    public ProyectoConsultoria(String codigoProyecto, String areaProyecto, boolean estaActivo, int fechaInicioProyecto, double presupuestoProyecto, Cliente cliente, Consultor consultor) {
        establecerCodigoProyecto(codigoProyecto);
        establecerAreaProyecto(areaProyecto);
        this.estaActivo = estaActivo;
        this.fechaInicioProyecto = fechaInicioProyecto;
        establecerPresupuestoProyecto(presupuestoProyecto);
        this.clientePrincipal = cliente;
        this.consultorAsignado = consultor;
    }

    // SOBRECARGA DE CONSTRUCTORES
    public ProyectoConsultoria(String codigoProyecto, String areaProyecto, Cliente cliente, Consultor consultor) {
        // Constructor 2 (PROYECTO BORRADOR): Asume no activo, fecha 0, presupuesto 1000.0
        this(codigoProyecto, areaProyecto, false, 0, 1000.0, cliente, consultor);
    }

    public ProyectoConsultoria(String codigoProyecto, String areaProyecto, Cliente cliente) {
        // Constructor 3 (PROYECTO MÍNIMO ACTIVO): Asume activo, fecha 0, presupuesto 1000.0, sin consultor.
        this(codigoProyecto, areaProyecto, true, 0, 1000.0, cliente, null);
    }

    // MÉTODOS DE NEGOCIO
    public String obtenerInfoResumida() {
        String nombreConsultor = (consultorAsignado != null) ? consultorAsignado.obtenerNombreConsultor() : "No Asignado";

        return "Código Proyecto: " + this.codigoProyecto +
                " | Área: " + this.areaProyecto +
                " | Cliente: " + this.clientePrincipal.obtenerNombreEmpresa() +
                " | Consultor: " + nombreConsultor;
    }

    public double calcularTarifaDiaria() {
        final int DIAS_ESTANDAR_PROYECTO = 120;
        return this.presupuestoProyecto / DIAS_ESTANDAR_PROYECTO;
    }

    // METODO AUXILIAR PRIVADO
    private boolean esCodigoProyectoValido(String codigo) {
        // Código no nulo y debe tener entre 5 y 10 caracteres.
        return codigo != null && codigo.length() >= 5 && codigo.length() <= 10;
    }

    // GETTERS
    public String obtenerCodigoProyecto() { return codigoProyecto; }
    public double obtenerPresupuestoProyecto() { return presupuestoProyecto; }
    public String obtenerAreaProyecto() { return areaProyecto; }
    public Cliente obtenerClientePrincipal() { return clientePrincipal; }
    public boolean estaActivo() { return estaActivo; }

    // SETTERS CON VALIDACIÓN
    public void establecerCodigoProyecto(String codigoProyecto) {
        if (!esCodigoProyectoValido(codigoProyecto)) {
            throw new IllegalArgumentException("Código de proyecto inválido. Debe tener entre 5 y 10 caracteres.");
        }
        this.codigoProyecto = codigoProyecto;
    }

    public void establecerAreaProyecto(String areaProyecto) {
        if (areaProyecto == null || areaProyecto.trim().isEmpty()) {
            throw new IllegalArgumentException("El área del proyecto no puede ser nula o vacía.");
        }
        this.areaProyecto = areaProyecto;
    }

    public void establecerPresupuestoProyecto(double presupuestoProyecto) {
        if (presupuestoProyecto <= 0) {
            throw new IllegalArgumentException("El presupuesto del proyecto debe ser mayor que cero.");
        }
        this.presupuestoProyecto = presupuestoProyecto;
    }

    public void establecerSiEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }
}