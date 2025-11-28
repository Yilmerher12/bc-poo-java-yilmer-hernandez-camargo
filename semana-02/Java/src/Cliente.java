public class Cliente {

        // Atributos (Mínimo 3)
        private String nit;
        private String companyName;
        private String principalContact;
        private String companySector;
        private double accountStatus;

        // Constructor Completo
        public Cliente(String nit, String companyName, String principalContact, String companySector, double accountStatus) {
            this.nit = nit;
            this.companyName = companyName;
            this.principalContact = principalContact;
            this.companySector = companySector;
            this.accountStatus = accountStatus;
        }

        public boolean hasAPendingDebt() {
            return this.accountStatus > 0;
        }

        public void requestService(String areaRequerida) {
            System.out.println("Client " + this.companyName + " has requested a project in the area " + areaRequerida + ".");
        }

        // Getters
        public String getNit() {
            return nit;
        }

        public String getCompanyName() {
            return companyName;
        }

        public double getAccountStatus() {
            return accountStatus;
        }

        // Setters
        public void setPrincipalContact(String principalContact) {
            this.principalContact = principalContact;
        }

        public void updatedAccountStatus(double monto) {
            // Suma el monto a la cuenta. Si el monto es negativo, es un pago.
            this.accountStatus += monto;

    }
}
