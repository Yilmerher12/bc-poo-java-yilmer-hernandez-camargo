public class Facturacion {

    private Cliente clienteResponsable;
    private String numeroFactura;
    private int fechaEmision;
    private double montoTotal;
    private String codigoProyectoRelacionado;
    private boolean estadoPago;

    // CONSTRUCTOR 1
    public Facturacion(String numeroFactura, int fechaEmision, double montoTotal, String codigoProyectoRelacionado, Cliente clienteResponsable) {
        setNumeroFactura(numeroFactura);
        setMontoTotal(montoTotal);
        this.fechaEmision = fechaEmision;
        this.codigoProyectoRelacionado = codigoProyectoRelacionado;
        this.estadoPago = false;
        this.clienteResponsable = clienteResponsable;
    }

    // SOBRECARGA DE CONSTRUCTORES
    public Facturacion(String numeroFactura, Cliente clienteResponsable, String codigoProyectoRelacionado) {
        this(numeroFactura, 0, 0.0, codigoProyectoRelacionado, clienteResponsable);
    }
    public Facturacion(String numeroFactura, Cliente clienteResponsable) {
        this(numeroFactura, 0, 0.0, "N/A", clienteResponsable);
    }

    // Metodo AUXILIAR PRIVADO
    private boolean esNumeroFacturaValido(String numero) {
        return numero != null && numero.length() == 7;
    }

    // MÉTODOS DE NEGOCIO
    public void registrarPago() {
        if (!this.estadoPago) {
            this.estadoPago = true;
            this.clienteResponsable.actualizarEstadoCuenta(-this.montoTotal);
            System.out.println("✅ Pago registrado para Factura " + this.numeroFactura + ". Cuenta del cliente actualizada.");
        }
    }
    public void mostrarEstadoInvolucrado() {
        String estado = this.estadoPago ? "PAGADA" : "PENDIENTE";
        System.out.println("Factura " + this.numeroFactura + " (Monto: $" + this.montoTotal + ") - Estado: " + estado);
    }

    // GETTERS
    public String getNumeroFactura() { 
        return numeroFactura; 
    }
    public double getMontoTotal() { 
        return montoTotal; 
    }
    public Cliente getClienteResponsable() { 
        return clienteResponsable; 
    }

    // SETTERS
    public void setNumeroFactura(String numeroFactura) {
        if (!esNumeroFacturaValido(numeroFactura)) {
            throw new IllegalArgumentException("Número de factura inválido. Debe tener exactamente 7 caracteres.");
        }
        this.numeroFactura = numeroFactura;
    }
    public void setMontoTotal(double montoTotal) {
        if (montoTotal <= 0) {
            throw new IllegalArgumentException("El monto total de la factura debe ser mayor que cero.");
        }
        this.montoTotal = montoTotal;
    }
}