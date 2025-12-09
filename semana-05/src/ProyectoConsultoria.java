public class ProyectoConsultoria {

    private Cliente clientePrincipal; 
    private Consultor consultorAsignado; 
    private String codigoProyecto;
    private String areaProyecto;
    private boolean estaActivo;
    private int fechaInicioProyecto;
    private double presupuestoProyecto;

    // CONSTRUCTOR 1
    public ProyectoConsultoria(String codigoProyecto, String areaProyecto, boolean estaActivo, int fechaInicioProyecto, double presupuestoProyecto, Cliente cliente, Consultor consultor) {
        setCodigoProyecto(codigoProyecto);
        setAreaProyecto(areaProyecto);
        this.estaActivo = estaActivo;
        this.fechaInicioProyecto = fechaInicioProyecto;
        setPresupuestoProyecto(presupuestoProyecto);
        this.clientePrincipal = cliente;
        this.consultorAsignado = consultor;
    }

    // SOBRECARGA DE CONSTRUCTORES
    public ProyectoConsultoria(String codigoProyecto, String areaProyecto, Cliente cliente, Consultor consultor) {
        this(codigoProyecto, areaProyecto, false, 0, 1000.0, cliente, consultor);
    }
    public ProyectoConsultoria(String codigoProyecto, String areaProyecto, Cliente cliente) {
        this(codigoProyecto, areaProyecto, true, 0, 1000.0, cliente, null);
    }

    // MÉTODOS DE NEGOCIO
    public String getInfoResumida() {
        String nombreConsultor = (consultorAsignado != null) ? consultorAsignado.getNombreConsultor() : "No Asignado";

        return "Código Proyecto: " + this.codigoProyecto +
                " | Área: " + this.areaProyecto +
                " | Cliente: " + this.clientePrincipal.getNombreEmpresa() +
                " | Consultor: " + nombreConsultor;
    }

    public double calcularTarifaDiaria() {
        final int DIAS_ESTANDAR_PROYECTO = 120;
        return this.presupuestoProyecto / DIAS_ESTANDAR_PROYECTO;
    }
    private boolean esCodigoProyectoValido(String codigo) {
        return codigo != null && codigo.length() >= 5 && codigo.length() <= 10;
    }

    // GETTERS
    public String getCodigoProyecto() { 
        return codigoProyecto; 
    }
    public double getPresupuestoProyecto() {
        return presupuestoProyecto; 
    }
    public String getAreaProyecto() { 
        return areaProyecto; 
    }
    public Cliente getClientePrincipal() { 
        return clientePrincipal; 
    }
    public boolean isEstaActivo() { 
        return estaActivo; 
    }

    // SETTERS
    public void setCodigoProyecto(String codigoProyecto) {
        if (!esCodigoProyectoValido(codigoProyecto)) {
            throw new IllegalArgumentException("Código de proyecto inválido. Debe tener entre 5 y 10 caracteres.");
        }
        this.codigoProyecto = codigoProyecto;
    }
    public void setAreaProyecto(String areaProyecto) {
        if (areaProyecto == null || areaProyecto.trim().isEmpty()) {
            throw new IllegalArgumentException("El área del proyecto no puede ser nula o vacía.");
        }
        this.areaProyecto = areaProyecto;
    }
    public void setPresupuestoProyecto(double presupuestoProyecto) {
        if (presupuestoProyecto <= 0) {
            throw new IllegalArgumentException("El presupuesto del proyecto debe ser mayor que cero.");
        }
        this.presupuestoProyecto = presupuestoProyecto;
    }
    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }
}