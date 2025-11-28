public class Consultor {

    // Atributos (Mínimo 3)
    private String idConsultant;
    private String consultantName;
    private String consultantSpeciality; // Relación con el área de proyecto
    private double hourlyFee;
    private int yearsOfService;

    //Constructor
    public Consultor(String idConsultant, String consultantName, String consultantSpeciality, double hourlyFee, int yearsOfService) {
        this.idConsultant = idConsultant;
        this.consultantName = consultantName;
        this.consultantSpeciality = consultantSpeciality;
        this.hourlyFee = hourlyFee;
        this.yearsOfService = yearsOfService;
    }

    //Methods
    public double calculateEstimatedMonthlyCost(int horasMensuales) {
        // Asume un mes laboral estándar para estimar el costo fijo.
        return this.hourlyFee * horasMensuales;
    }

    // Getters
    public String getIdConsultant() {
        return idConsultant;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public String getConsultantSpeciality() {
        return consultantSpeciality;
    }

    public double getHourlyFee() {
        return hourlyFee;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    // Setters
    public void setHourlyFee(double hourlyFee) {
        if (hourlyFee > 0) {
            this.hourlyFee = hourlyFee;
        }
    }

    public void setConsultantSpeciality(String consultantSpeciality) {
        this.consultantSpeciality = consultantSpeciality;
    }
}
