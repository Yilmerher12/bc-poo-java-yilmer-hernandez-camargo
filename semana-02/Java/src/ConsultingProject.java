public class ConsultingProject {

    private Cliente principalCliente;
    private Consultor assignedConsultor;
    private String projectCode;
    protected String projectArea;
    protected boolean isActive;
    protected int projectStartYear;
    private double projectBudget;

    public ConsultingProject(String projectCode, String projectArea, boolean isActive, int projectStartYear, double projectBudget, Cliente principalCliente, Consultor assignedConsultor) {

        this.projectCode = projectCode;
        this.projectArea = projectArea;
        this.isActive = isActive;
        this.projectStartYear = projectStartYear;
        this.projectBudget = projectBudget;
        this.principalCliente = principalCliente;
        this.assignedConsultor = assignedConsultor;
    }

    public String getSummarizedInfo() {
        return "Project Code: " + this.projectCode +
                " | Area: " + this.projectArea +
                " | Client: " + this.principalCliente.getCompanyName() +
                " | Consultant: " + this.assignedConsultor.getConsultantName();
    }

    public void showProjectInfo() {
        System.out.println("--- Project POO ---");
        System.out.println("Project's code: " + this.projectCode);
        System.out.println("Project's area: " + this.projectArea);
        System.out.println("Project's budget: $" + this.projectBudget);
        System.out.println("Is the project active: " + this.isActive);
        System.out.println("Project's date: " + this.projectStartYear);
    }
    public double calculateFinalFee() {
        // Constant about the project days (Example)
        final int PROJECT_USUAL_DAYS = 120;
        return this.projectBudget / PROJECT_USUAL_DAYS;
    }
    // Getter from the projectCode Variable
    public String getProjectCode() {
        return projectCode;
    }

    // Getter and Setter from the projectBudget Variable
    public double getProjectBudget() {
        return projectBudget;
    }
    public void setProjectBudget(double projectBudget) {
        if (projectBudget > 0) {
            this.projectBudget = projectBudget;
        } else {
            System.out.println("Error: The Budget should be a positive value.");
        }

    }
}
