public class Billing {
    private String invoiceNumber;
    private int releaseDate;
    private double totalAmount;
    private String codeRelatedToProject;
    private boolean paymentStatus;

    public Billing(String invoiceNumber, int releaseDate, double totalAmount, String codeRelatedToProject, boolean paymentStatus) {
        this.invoiceNumber = invoiceNumber;
        this.releaseDate = releaseDate;
        this.totalAmount = totalAmount;
        this.codeRelatedToProject = codeRelatedToProject;
        this.paymentStatus = false;
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
            System.out.println("Invoice Payment " + this.invoiceNumber + " successful register .");
        } else {
            System.out.println("The invoice " + this.invoiceNumber + " was already paid.");
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

