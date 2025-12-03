public class Cliente {
    private String nit;
    private String nombreEmpresa;
    private String contactoPrincipal;
    private String sectorEmpresa;
    private double estadoCuenta; 

    // CONSTRUCTOR 1
    public Cliente(String nit, String nombreEmpresa, String contactoPrincipal, String sectorEmpresa, double estadoCuenta) {
        setNit(nit);
        setNombreEmpresa(nombreEmpresa);
        this.contactoPrincipal = contactoPrincipal;
        this.sectorEmpresa = sectorEmpresa;
        this.estadoCuenta = estadoCuenta;
    }

    // SOBRECARGA DE CONSTRUCTORES
    public Cliente(String nit, String nombreEmpresa, String contactoPrincipal, String sectorEmpresa) {
        this(nit, nombreEmpresa, contactoPrincipal, sectorEmpresa, 0.0);
    }
    public Cliente(String nit, String nombreEmpresa) {
        this(nit, nombreEmpresa, "N/A", "General", 0.0);
    }

    // MÉTODOS DE NEGOCIO
    public boolean tieneDeudaPendiente() {
        return this.estadoCuenta > 0;
    }
    public void actualizarEstadoCuenta(double monto) {
        this.estadoCuenta += monto;
    }
    private boolean esNitValido(String nit) {
        return nit != null && nit.length() >= 6;
    }

    // GETTERS
    public String getNit() {
        return nit; 
    }
    public String getNombreEmpresa() {
        return nombreEmpresa; 
    }
    public String getContactoPrincipal() {
        return contactoPrincipal; 
    }
    public String getSectorEmpresa() {
        return sectorEmpresa;
    }
    public double getEstadoCuenta() { 
        return estadoCuenta; 
    }
    
    // SETTERS
    public void setNombreEmpresa(String nombreEmpresa) {
        if (nombreEmpresa == null || nombreEmpresa.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la empresa no puede ser nulo o vacío.");
        }
        this.nombreEmpresa = nombreEmpresa;
    }
    public void setNit(String nit) {
        if (!esNitValido(nit)) {
            throw new IllegalArgumentException("NIT inválido. Debe tener al menos 6 caracteres.");
        }
        this.nit = nit;
    }
    public void setContactoPrincipal(String contactoPrincipal) {
        this.contactoPrincipal = contactoPrincipal; 
    }
    public void setSectorEmpresa(String sectorEmpresa) { 
        this.sectorEmpresa = sectorEmpresa; 
    }
}
