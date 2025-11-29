public class Cliente {

    // Atributos (Mínimo 3)
    private String nit;
    private String companyName;
    private String principalContact;
    private String companySector;
    private double accountStatus;

    // CONSTRUCTOR 1 (COMPLETO / PRINCIPAL): Recibe todos los datos.
    public Cliente(String nit, String companyName, String principalContact, String companySector, double accountStatus) {
        // Llama a los setters con validación (Ej. 1)
        setNit(nit);
        setCompanyName(companyName);
        this.principalContact = principalContact;
        this.companySector = companySector;
        this.accountStatus = accountStatus;
    }

    // SOBRECARGA CONSTRUCTORES

    // CONSTRUCTOR 2 (BÁSICO): Recibe 4 parámetros, el saldo es por defecto 0.0
    public Cliente(String nit, String companyName, String principalContact, String companySector) {
        // Llama al Constructor 1 (el completo) con un valor fijo de 0.0 para el saldo.
        // Esto asegura que la validación se ejecute.
        this(nit, companyName, principalContact, companySector, 0.0);
    }

    // CONSTRUCTOR 3 (MÍNIMO): Recibe solo 2 parámetros (NIT y Nombre).
    public Cliente(String nit, String companyName) {
        // Llama al Constructor 1, fijando Contacto a "N/A" y Sector a "General", y Saldo a 0.0.
        this(nit, companyName, "N/A", "General", 0.0);
    }

    // MÉTODOS DE NEGOCIO (Ya existentes)
    public boolean hasAPendingDebt() {
        return this.accountStatus > 0;
    }

    public void updatedAccountStatus(double monto) {
        this.accountStatus += monto;
    }

    // --- NUEVO ---
    private boolean isNitValid(String nit) {
        // Validación: NIT debe tener al menos 6 caracteres y no ser nulo.
        // Si el NIT es válido, el método devuelve TRUE.
        return nit != null && nit.length() >= 6;
    }

    // GETTERS (Solo retornan el valor)
    public String getNit() {
        return nit;
    }
    public String getCompanyName() {
            return companyName;
        }
    public String getPrincipalContact() {
            return principalContact;
        }
    public String getCompanySector() {
            return companySector;
        }
    public double getAccountStatus() {
            return accountStatus;
        }

    // SETTERS CON VALIDACIÓN (Cumplen con el Ejercicio 1)

    public void setCompanyName(String companyName) {
        // VALIDACIÓN: El nombre no puede ser nulo o vacío
        if (companyName == null || companyName.trim().isEmpty()) {
            // Sintaxis 'THROW': Si falla la validación, lanzamos un error.
            throw new IllegalArgumentException("El nombre de la empresa no puede ser nulo o vacío.");
        }
        this.companyName = companyName;
    }

    public void setNit(String nit) {
        // VALIDACIÓN: Usa el método auxiliar privado
        if (!isNitValid(nit)) {
            // Si el método privado devuelve FALSE (!isNitValid), lanzamos error.
            throw new IllegalArgumentException("NIT inválido. Debe tener al menos 6 caracteres.");
        }
        this.nit = nit;
    }

    // El resto de setters son simples ya que no tienen restricciones lógicas fuertes:
    public void setPrincipalContact(String principalContact) {
        this.principalContact = principalContact;
    }

    public void setCompanySector(String companySector) {
        this.companySector = companySector;
    }
}
