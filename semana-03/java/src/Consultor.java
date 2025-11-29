public class Consultor {

    // 1. ATRIBUTOS PRIVATE
    private String idConsultant;
    private String consultantName;
    private String consultantSpeciality;
    private double hourlyFee;
    private int yearsOfService;

    // CONSTRUCTOR 1 (PRINCIPAL / COMPLETO): 5 parámetros.
    public Consultor(String idConsultant, String consultantName, String consultantSpeciality, double hourlyFee, int yearsOfService) {
        // Llama a los setters con validación
        setIdConsultant(idConsultant);
        setConsultantName(consultantName);
        this.consultantSpeciality = consultantSpeciality;
        setHourlyFee(hourlyFee);
        setYearsOfService(yearsOfService);
    }

    // CONSTRUCTOR 2 (BÁSICO): 4 parámetros. Asume 0 años de servicio.
    public Consultor(String idConsultant, String consultantName, String consultantSpeciality, double hourlyFee) {
        // Llama al Constructor 1, fijando yearsOfService a 0
        this(idConsultant, consultantName, consultantSpeciality, hourlyFee, 0);
    }

    // CONSTRUCTOR 3 (MÍNIMO): 2 parámetros. Asume especialidad "General", tarifa 30.0 y 0 años.
    public Consultor(String idConsultant, String consultantName) {
        // Llama al Constructor 1, asumiendo valores por defecto
        this(idConsultant, consultantName, "General", 30.0, 0);
    }

    // MÉTODO DE NEGOCIO
    public double calculateEstimatedMonthlyCost(int horasMensuales) {
        return this.hourlyFee * horasMensuales;
    }

    // --- NUEVO ---
    // MÉTODO AUXILIAR PRIVADO: Valida que el ID cumpla el formato
    private boolean isValidId(String id) {
        // Regla: ID no nulo, debe empezar con 'C' y tener al menos 4 caracteres.
        return id != null && id.toUpperCase().startsWith("C") && id.length() >= 4;
    }

    // GETTERS (Solo retornan el valor)
    public String getIdConsultant() { return idConsultant; }
    public String getConsultantName() { return consultantName; }
    public String getConsultantSpeciality() { return consultantSpeciality; }
    public double getHourlyFee() { return hourlyFee; }
    public int getYearsOfService() { return yearsOfService; }

    // SETTERS CON VALIDACIÓN (Cumplen con Encapsulación Completa)

    public void setIdConsultant(String idConsultant) {
        if (!isValidId(idConsultant)) { // Usa el método privado auxiliar
            throw new IllegalArgumentException("ID inválido. Debe empezar con 'C' y tener al menos 4 caracteres.");
        }
        this.idConsultant = idConsultant;
    }

    public void setConsultantName(String consultantName) {
        // Validación: Nombre no puede ser nulo o vacío
        if (consultantName == null || consultantName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del consultor no puede ser vacío.");
        }
        this.consultantName = consultantName;
    }

    public void setHourlyFee(double hourlyFee) {
        // Validación: Tarifa debe ser positiva
        if (hourlyFee <= 0) {
            throw new IllegalArgumentException("La tarifa por hora debe ser mayor que cero.");
        }
        this.hourlyFee = hourlyFee;
    }

    public void setYearsOfService(int yearsOfService) {
        // Validación: Años de servicio no pueden ser negativos
        if (yearsOfService < 0) {
            throw new IllegalArgumentException("Los años de servicio no pueden ser negativos.");
        }
        this.yearsOfService = yearsOfService;
    }

    public void setConsultantSpeciality(String consultantSpeciality) {
        this.consultantSpeciality = consultantSpeciality;
    }
}
