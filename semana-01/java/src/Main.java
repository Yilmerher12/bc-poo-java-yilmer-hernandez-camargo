
public class Main {
    public static void main (String[] args){
        System.out.println("\nCONSULTING PROJECT");

        System.out.println("\nCreation Projects");

        //First Project Marketing
        ConsultingProject firstProject = new ConsultingProject("MKT-001", "Marketing", true, 20250115, 12000.00);

        //Second Project Logistic
        ConsultingProject secondProject = new ConsultingProject("LOG-001", "Logistic", true, 20231001, 7500.50);

        // First and second bill objects
        Billing firstBill = new Billing("FACT-001", 20250201, 12000.00, firstProject.getProjectCode(), false);
        Billing secondBill = new Billing("FACT-002", 20231215, 7500.50, secondProject.getProjectCode(), true);


        //CONSULTING PROJECT
        System.out.println("\nUsing the methods for each object");

        // First Project with all its methods
        firstProject.showProjectInfo();

        double feeP1 = firstProject.calculateFinalFee();
        System.out.println("\nEstimated daily rate (MKT-001): $" + feeP1);

        System.out.println("Project's code: " + firstProject.getProjectCode());

        System.out.println("\nDefault budget: $" + firstProject.getProjectBudget());

        firstProject.setProjectBudget(15000.00);
        System.out.println("New budget: $" + firstProject.getProjectBudget());


        // Second Project with all its methods
        System.out.println("\n-------Project LOG-001 (Updated data)-------");
        secondProject.showProjectInfo();

        double feeP2 = secondProject.calculateFinalFee();
        System.out.println("\nEstimated daily rate (LOG-001): $" + feeP2);
        System.out.println("Project's code: " + secondProject.getProjectCode());

        System.out.println("\nDefault budget: $" + secondProject.getProjectBudget());

        secondProject.setProjectBudget(10000.00);
        System.out.println("New budget: $" + secondProject.getProjectBudget());



        System.out.println("\n-------3. Billing information-------");

        // First Bill with its methods
        firstBill.showInvolveStatus();

        double taxesF1 = firstBill.calculateTaxes(0.19);
        System.out.println("\nTaxes to pay (19%): $" + taxesF1);

        firstBill.registerPayment();

        // Show again because it has changed
        System.out.println("\n-------Bill status FACT-001 after paid-------");
        firstBill.showInvolveStatus();

        // Second Bill with its methods
        System.out.println("\n-------Bill FACT-002-------");
        secondBill.showInvolveStatus();
        double taxesF2 = secondBill.calculateTaxes(0.10);
        System.out.println("Taxes to pay (10%): $" + taxesF2);

        firstBill.registerPayment();


        System.out.println("\n-------Taxes Total Amount-------");
        System.out.println(firstBill.getTotalAmount());
        System.out.println(secondBill.getTotalAmount());
    }
}

