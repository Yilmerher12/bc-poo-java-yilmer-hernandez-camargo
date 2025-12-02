public class Facturacion {

    // 1. ATRIBUTOS PRIVATE
    private Cliente clienteResponsable;
    private String numeroFactura;
    private int fechaEmision;
    private double montoTotal;
    private String codigoProyectoRelacionado;
    private boolean estadoPago;

    // CONSTRUCTOR 1 (PRINCIPAL / COMPLETO)
    public Facturacion(String numeroFactura, int fechaEmision, double montoTotal, String codigoProyectoRelacionado, Cliente clienteResponsable) {
        establecerNumeroFactura(numeroFactura);
        establecerMontoTotal(montoTotal);
        this.fechaEmision = fechaEmision;
        this.codigoProyectoRelacionado = codigoProyectoRelacionado;
        this.estadoPago = false; // Por defecto: No pagada
        this.clienteResponsable = clienteResponsable;
    }

    // SOBRECARGA DE CONSTRUCTORES
    public Facturacion(String numeroFactura, Cliente clienteResponsable, String codigoProyectoRelacionado) {
        // Constructor 2 (PRELIMINAR): Asume monto 0.0 y fecha 0
        this(numeroFactura, 0, 0.0, codigoProyectoRelacionado, clienteResponsable);
    }

    public Facturacion(String numeroFactura, Cliente clienteResponsable) {
        // Constructor 3 (SIMPLE): Asume fecha 0, monto 0.0 y código "N/A"
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
            // Comunicación entre objetos: Factura actualiza el saldo del Cliente
            this.clienteResponsable.actualizarEstadoCuenta(-this.montoTotal);
            System.out.println("✅ Pago registrado para Factura " + this.numeroFactura + ". Cuenta del cliente actualizada.");
        }
    }

    public void mostrarEstadoInvolucrado() {
        String estado = this.estadoPago ? "PAGADA" : "PENDIENTE";
        System.out.println("Factura " + this.numeroFactura + " (Monto: $" + this.montoTotal + ") - Estado: " + estado);
    }

    // GETTERS
    public String obtenerNumeroFactura() { return numeroFactura; }
    public double obtenerMontoTotal() { return montoTotal; }
    public Cliente obtenerClienteResponsable() { return clienteResponsable; }

    // SETTERS CON VALIDACIÓN
    public void establecerNumeroFactura(String numeroFactura) {
        if (!esNumeroFacturaValido(numeroFactura)) {
            throw new IllegalArgumentException("Número de factura inválido. Debe tener exactamente 7 caracteres.");
        }
        this.numeroFactura = numeroFactura;
    }

    public void establecerMontoTotal(double montoTotal) {
        if (montoTotal <= 0) {
            throw new IllegalArgumentException("El monto total de la factura debe ser mayor que cero.");
        }
        this.montoTotal = montoTotal;
    }
    // Nota: estadoPago no tiene setter, se cambia solo con registrarPago()
}