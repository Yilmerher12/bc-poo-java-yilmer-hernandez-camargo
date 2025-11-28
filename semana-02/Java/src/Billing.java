public class Billing {

    private Cliente responsibleClient; // Relación con la clase Cliente
    private String invoiceNumber;
    private int releaseDate;
    private double totalAmount;
    private String codeRelatedToProject;
    private boolean paymentStatus;

    public Billing(String invoiceNumber, int releaseDate, double totalAmount, String codeRelatedToProject, Cliente responsibleClient) {
        this.invoiceNumber = invoiceNumber;
        this.releaseDate = releaseDate;
        this.totalAmount = totalAmount;
        this.codeRelatedToProject = codeRelatedToProject;
        this.paymentStatus = false;
        this.responsibleClient = responsibleClient;
    }
    public void showInvolveStatus() {
        String status;
        if (this.paymentStatus == true){
            status = "ALREADY PAID";
        }else {
            status = "PENDING";
        }
        System.out.println("--- No. INVOICE " + this.invoiceNumber+ " ---");
        System.out.println("Related project: " + this.codeRelatedToProject);
        System.out.println("Total Amount: $" + this.totalAmount);
        System.out.println("PaymentStatus: " + status);
    }
    public void registerPayment() {
        if (!this.paymentStatus) {
            this.paymentStatus = true;

            // Lógica de Negocio (Usando la relación):
            this.responsibleClient.updatedAccountStatus(-this.totalAmount);

            System.out.println("✅ Payment registered for Factura " + this.invoiceNumber + ". Client account updated.");
        }
    }
    public double calculateTaxes(double taxRate) {
        // Ejemplo: IVA del 19%
        return this.totalAmount * taxRate;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
}
