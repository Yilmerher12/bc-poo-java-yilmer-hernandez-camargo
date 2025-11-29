public class Billing {

    // 1. ATRIBUTOS PRIVATE
    private Cliente responsibleClient;
    private String invoiceNumber;
    private int releaseDate;
    private double totalAmount;
    private String codeRelatedToProject;
    private boolean paymentStatus;

    // CONSTRUCTOR 1 (PRINCIPAL / COMPLETO)
    public Billing(String invoiceNumber, int releaseDate, double totalAmount, String codeRelatedToProject, Cliente responsibleClient) {
        setInvoiceNumber(invoiceNumber);
        setTotalAmount(totalAmount);
        this.releaseDate = releaseDate;
        this.codeRelatedToProject = codeRelatedToProject;
        this.paymentStatus = false;
        this.responsibleClient = responsibleClient;
    }

    // CONSTRUCTOR 2 (FACTURA PRELIMINAR): 3 parámetros. Asume monto $0.00 y fecha 0.
    public Billing(String invoiceNumber, Cliente responsibleClient, String codeRelatedToProject) {
        // Llama al Constructor 1, fijando fecha a 0 y totalAmount a 0.0
        this(invoiceNumber, 0, 0.0, codeRelatedToProject, responsibleClient);
    }

    // CONSTRUCTOR 3 (FACTURA SIMPLE): 2 parámetros. Solo número y cliente.
    public Billing(String invoiceNumber, Cliente responsibleClient) {
        // Llama al Constructor 1, asumiendo fecha=0, monto=0.0 y código="N/A"
        this(invoiceNumber, 0, 0.0, "N/A", responsibleClient);
    }

    // MÉTODO AUXILIAR PRIVADO
    private boolean isInvoiceNumberValid(String number) {
        // Regla: Número de factura no nulo y de 7 caracteres de largo (ej: FACT-001)
        return number != null && number.length() == 7;
    }

    // MÉTODOS DE NEGOCIO (Ya existentes)
    public void registerPayment() {
        if (!this.paymentStatus) {
            this.paymentStatus = true;
            this.responsibleClient.updatedAccountStatus(-this.totalAmount);
            System.out.println("✅ Payment registered for Factura " + this.invoiceNumber + ". Client account updated.");
        }
    }

    public void showInvolveStatus() {
        // ... (código existente) ...
    }

    // GETTERS
    public String getInvoiceNumber() { return invoiceNumber; }
    public double getTotalAmount() { return totalAmount; }
    public Cliente getResponsibleClient() { return responsibleClient; }


    // SETTERS CON VALIDACIÓN
    public void setInvoiceNumber(String invoiceNumber) {
        if (!isInvoiceNumberValid(invoiceNumber)) {
            throw new IllegalArgumentException("Número de factura inválido. Debe tener exactamente 7 caracteres (ej: XXX-001).");
        }
        this.invoiceNumber = invoiceNumber;
    }

    public void setTotalAmount(double totalAmount) {
        // Validación: El monto total debe ser positivo
        if (totalAmount <= 0) {
            throw new IllegalArgumentException("El monto total de la factura debe ser mayor que cero.");
        }
        this.totalAmount = totalAmount;
    }

    // No hay setter para paymentStatus, se cambia solo con registerPayment()
}