public class Facturacion {

    private Cliente clienteResponsable; // Relación con la clase Cliente
    private String numeroFactura;
    private int fechaEmision;
    private double montoTotal;
    private String codigoProyectoRelacionado;
    private boolean estadoPago;

    public Facturacion(String numeroFactura, int fechaEmision, double montoTotal, String codigoProyectoRelacionado, Cliente clienteResponsable) {
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
        this.codigoProyectoRelacionado = codigoProyectoRelacionado;
        this.estadoPago = false; // La lógica de negocio establece que el pago siempre empieza como PENDIENTE
        this.clienteResponsable = clienteResponsable;
    }

    public void mostrarEstadoFactura() {
        String estado;
        if (this.estadoPago) {
            estado = "PAGADA";
        } else {
            estado = "PENDIENTE";
        }
        System.out.println("--- No. FACTURA " + this.numeroFactura + " ---");
        System.out.println("Proyecto Relacionado: " + this.codigoProyectoRelacionado);
        System.out.println("Monto Total: $" + this.montoTotal);
        System.out.println("Estado de Pago: " + estado);
    }

    public void registrarPago() {
        if (!this.estadoPago) {
            this.estadoPago = true;

            // Lógica de Negocio (Usando la relación):
            // El monto es negativo porque es una resta al saldo pendiente (saldo a favor del cliente)
            this.clienteResponsable.actualizarEstadoCuenta(-this.montoTotal);

            System.out.println("✅ Pago registrado para Factura " + this.numeroFactura + ". Cuenta del cliente actualizada.");
        }
    }

    public double calcularImpuestos(double tasaImpuestos) {
        // Por ejemplo: IVA del 19%
        return this.montoTotal * tasaImpuestos;
    }

    // Getters
    public double getMontoTotal() {
        return montoTotal;
    }
}