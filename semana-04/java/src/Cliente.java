public class Cliente {

    // ATRIBUTOS PRIVATE (Variables)
    private String nit;
    private String nombreEmpresa;
    private String contactoPrincipal;
    private String sectorEmpresa;
    private double estadoCuenta; // Saldo o deuda pendiente

    // CONSTRUCTOR 1 (PRINCIPAL / COMPLETO)
    public Cliente(String nit, String nombreEmpresa, String contactoPrincipal, String sectorEmpresa, double estadoCuenta) {
        // Se usan los setters con validación
        establecerNit(nit);
        establecerNombreEmpresa(nombreEmpresa);
        this.contactoPrincipal = contactoPrincipal;
        this.sectorEmpresa = sectorEmpresa;
        this.estadoCuenta = estadoCuenta;
    }

    // SOBRECARGA DE CONSTRUCTORES
    public Cliente(String nit, String nombreEmpresa, String contactoPrincipal, String sectorEmpresa) {
        // Constructor 2: Asume estadoCuenta inicial de 0.0
        this(nit, nombreEmpresa, contactoPrincipal, sectorEmpresa, 0.0);
    }

    public Cliente(String nit, String nombreEmpresa) {
        // Constructor 3: Asume "N/A" para contacto/sector y 0.0 para estadoCuenta
        this(nit, nombreEmpresa, "N/A", "General", 0.0);
    }

    // MÉTODOS DE NEGOCIO
    public boolean tieneDeudaPendiente() {
        return this.estadoCuenta > 0;
    }

    public void actualizarEstadoCuenta(double monto) {
        this.estadoCuenta += monto;
    }

    // METODO AUXILIAR PRIVADO
    private boolean esNitValido(String nit) {
        return nit != null && nit.length() >= 6;
    }

    // GETTERS (Obtener)
    public String obtenerNit() { return nit; }
    public String obtenerNombreEmpresa() { return nombreEmpresa; }
    public String obtenerContactoPrincipal() { return contactoPrincipal; }
    public String obtenerSectorEmpresa() { return sectorEmpresa; }
    public double obtenerEstadoCuenta() { return estadoCuenta; }

    // SETTERS (Establecer) CON VALIDACIÓN

    public void establecerNombreEmpresa(String nombreEmpresa) {
        if (nombreEmpresa == null || nombreEmpresa.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la empresa no puede ser nulo o vacío.");
        }
        this.nombreEmpresa = nombreEmpresa;
    }

    public void establecerNit(String nit) {
        if (!esNitValido(nit)) {
            throw new IllegalArgumentException("NIT inválido. Debe tener al menos 6 caracteres.");
        }
        this.nit = nit;
    }

    public void establecerContactoPrincipal(String contactoPrincipal) {
        this.contactoPrincipal = contactoPrincipal;
    }

    public void establecerSectorEmpresa(String sectorEmpresa) {
        this.sectorEmpresa = sectorEmpresa;
    }
}