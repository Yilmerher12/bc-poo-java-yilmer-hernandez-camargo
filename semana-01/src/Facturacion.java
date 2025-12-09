public class Facturacion {

    // Atributos (camelCase en español)
    private String numeroFactura;
    private int fechaEmision;
    private double montoTotal;
    private String codigoProyectoRelacionado;
    private boolean estadoPago;

    // Constructor
    public Facturacion(String numeroFactura, int fechaEmision, double montoTotal, String codigoProyectoRelacionado, boolean estadoPago) {
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
        this.codigoProyectoRelacionado = codigoProyectoRelacionado;
        // La lógica de negocio establece que el pago siempre empieza como PENDIENTE
        this.estadoPago = false;
    }

    // Metodo void (imprime información)
    public void mostrarEstadoFactura() {
        String estado;
        if (this.estadoPago){
            estado = "PAGADA";
        }else {
            estado = "PENDIENTE";
        }
        System.out.println("--- No. FACTURA " + this.numeroFactura + " ---");
        System.out.println("Proyecto Relacionado: " + this.codigoProyectoRelacionado);
        System.out.println("Monto Total: $" + this.montoTotal);
        System.out.println("Estado de Pago: " + estado);
    }

    // Metodo void (cambia el estado)
    public void registrarPago() {
        if (!this.estadoPago) {
            this.estadoPago = true;
            System.out.println("Pago de Factura " + this.numeroFactura + " registrado exitosamente.");
        } else {
            System.out.println("La factura " + this.numeroFactura + " ya estaba pagada.");
        }
    }

    // Metodo que retorna valor calculado
    public double calcularImpuestos(double tasaImpuestos) {
        // Ejemplo: IVA del 19%
        return this.montoTotal * tasaImpuestos;
    }

    // Getter (mínimo 1)
    public double getMontoTotal() {
        return montoTotal;
    }
}

