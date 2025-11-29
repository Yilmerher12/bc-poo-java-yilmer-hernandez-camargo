public class ConsultingProject {

    // 1. ATRIBUTOS PRIVATE
    private Cliente clientePrincipal;
    private Consultor consultorAsignado;
    private String projectCode;
    private String projectArea; // Lo cambiamos a private para la encapsulación completa
    private boolean isActive;
    private int projectStartDate;
    private double projectBudget;

    // CONSTRUCTOR 1 (PRINCIPAL / COMPLETO)
    public ConsultingProject(String projectCode, String projectArea, boolean isActive, int projectStartDate, double projectBudget, Cliente cliente, Consultor consultor) {
        setProjectCode(projectCode);
        setProjectArea(projectArea);
        this.isActive = isActive;
        this.projectStartDate = projectStartDate;
        setProjectBudget(projectBudget);
        this.clientePrincipal = cliente;
        this.consultorAsignado = consultor;
    }

    // CONSTRUCTOR 2 (PROYECTO BORRADOR): 4 parámetros. Sin presupuesto ni fecha de inicio.
    public ConsultingProject(String projectCode, String projectArea, Cliente cliente, Consultor consultor) {
        // Llama al Constructor 1, asumiendo isActive=false, fecha=0, presupuesto=1000.0 (mínimo)
        this(projectCode, projectArea, false, 0, 1000.0, cliente, consultor);
    }

    // CONSTRUCTOR 3 (PROYECTO MÍNIMO ACTIVO): 3 parámetros. Sin consultor ni fecha.
    public ConsultingProject(String projectCode, String projectArea, Cliente cliente) {
        // Llama al Constructor 1, asumiendo activo=true, fecha=0, presupuesto=1000.0, y consultor=null
        this(projectCode, projectArea, true, 0, 1000.0, cliente, null);
    }

    // MÉTODOS DE NEGOCIO (Ya existentes)
    public String obtenerInformacionResumida() {
        return "Project Code: " + this.projectCode +
                " | Area: " + this.projectArea +
                " | Client: " + this.clientePrincipal.getCompanyName() +
                " | Consultant: " + this.consultorAsignado.getConsultantName();
    }

    public double calcularTarifaDiaria() {
        final int DIAS_ESTANDAR_PROYECTO = 120;
        return this.projectBudget / DIAS_ESTANDAR_PROYECTO;
    }

    // MÉTODO AUXILIAR PRIVADO
    private boolean isValidProjectCode(String code) {
        // Código no nulo y debe tener entre 5 y 10 caracteres.
        return code != null && code.length() >= 5 && code.length() <= 10;
    }

    // GETTERS
    public String getProjectCode() { return projectCode; }
    public double getProjectBudget() { return projectBudget; }
    public String getProjectArea() { return projectArea; }
    public Cliente getClientePrincipal() { return clientePrincipal; }
    public boolean isActive() { return isActive; }

    // SETTERS CON VALIDACIÓN
    public void setProjectCode(String projectCode) {
        if (!isValidProjectCode(projectCode)) { // Usa el método auxiliar privado
            throw new IllegalArgumentException("Código de proyecto inválido. Debe tener entre 5 y 10 caracteres.");
        }
        this.projectCode = projectCode;
    }

    public void setProjectArea(String projectArea) {
        if (projectArea == null || projectArea.trim().isEmpty()) {
            throw new IllegalArgumentException("El área del proyecto no puede ser nula o vacía.");
        }
        this.projectArea = projectArea;
    }

    public void setProjectBudget(double projectBudget) {
        // Validación: Presupuesto debe ser positivo
        if (projectBudget <= 0) {
            throw new IllegalArgumentException("El presupuesto del proyecto debe ser mayor que cero.");
        }
        this.projectBudget = projectBudget;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    // NOTA: No hay setter para clientePrincipal ni consultorAsignado, ya que no deberían cambiarse una vez iniciado el proyecto.
}