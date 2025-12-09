public class Cliente {

    // Atributos
    private String nit;
    private String nombreEmpresa;
    private String contactoPrincipal;
    private String sectorEmpresa;
    private double estadoCuenta; // Saldo pendiente (positivo) o a favor (negativo)

    // Constructor Completo
    public Cliente(String nit, String nombreEmpresa, String contactoPrincipal, String sectorEmpresa, double estadoCuenta) {
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
        this.contactoPrincipal = contactoPrincipal;
        this.sectorEmpresa = sectorEmpresa;
        this.estadoCuenta = estadoCuenta;
    }

    public boolean tieneDeudaPendiente() {
        return this.estadoCuenta > 0;
    }

    public void solicitarServicio(String areaRequerida) {
        System.out.println("Cliente " + this.nombreEmpresa + " ha solicitado un proyecto en el área de " + areaRequerida + ".");
    }

    // Getters
    public String getNit() {
        return nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public double getEstadoCuenta() {
        return estadoCuenta;
    }

    // Setters
    public void setContactoPrincipal(String contactoPrincipal) {
        this.contactoPrincipal = contactoPrincipal;
    }

    public void actualizarEstadoCuenta(double monto) {
        // Suma el monto a la cuenta. Si el monto es negativo, es un pago.
        this.estadoCuenta += monto;
    }
}