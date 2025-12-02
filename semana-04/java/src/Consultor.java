public class Consultor {

    // ATRIBUTOS PRIVATE
    private String idConsultor;
    private String nombreConsultor;
    private String especialidadConsultor;
    private double tarifaPorHora;
    private int anosDeServicio;

    // CONSTRUCTOR 1 (PRINCIPAL / COMPLETO)
    public Consultor(String idConsultor, String nombreConsultor, String especialidadConsultor, double tarifaPorHora, int anosDeServicio) {
        // Llama a los setters con validación
        establecerIdConsultor(idConsultor);
        establecerNombreConsultor(nombreConsultor);
        this.especialidadConsultor = especialidadConsultor;
        establecerTarifaPorHora(tarifaPorHora);
        establecerAnosDeServicio(anosDeServicio);
    }

    // SOBRECARGA DE CONSTRUCTORES
    public Consultor(String idConsultor, String nombreConsultor, String especialidadConsultor, double tarifaPorHora) {
        // Constructor 2: Asume 0 años de servicio.
        this(idConsultor, nombreConsultor, especialidadConsultor, tarifaPorHora, 0);
    }

    public Consultor(String idConsultor, String nombreConsultor) {
        // Constructor 3: Asume especialidad "General", tarifa 30.0 y 0 años.
        this(idConsultor, nombreConsultor, "General", 30.0, 0);
    }

    // MÉTODO DE NEGOCIO
    public double calcularCostoMensualEstimado(int horasMensuales) {
        return this.tarifaPorHora * horasMensuales;
    }

    // MÉTODO AUXILIAR PRIVADO
    private boolean esIdValido(String id) {
        // Regla: ID no nulo, debe empezar con 'C' y tener al menos 4 caracteres.
        return id != null && id.toUpperCase().startsWith("C") && id.length() >= 4;
    }

    // GETTERS
    public String obtenerIdConsultor() { return idConsultor; }
    public String obtenerNombreConsultor() { return nombreConsultor; }
    public String obtenerEspecialidadConsultor() { return especialidadConsultor; }
    public double obtenerTarifaPorHora() { return tarifaPorHora; }
    public int obtenerAnosDeServicio() { return anosDeServicio; }

    // SETTERS CON VALIDACIÓN
    public void establecerIdConsultor(String idConsultor) {
        if (!esIdValido(idConsultor)) {
            throw new IllegalArgumentException("ID inválido. Debe empezar con 'C' y tener al menos 4 caracteres.");
        }
        this.idConsultor = idConsultor;
    }

    public void establecerNombreConsultor(String nombreConsultor) {
        if (nombreConsultor == null || nombreConsultor.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del consultor no puede ser vacío.");
        }
        this.nombreConsultor = nombreConsultor;
    }

    public void establecerTarifaPorHora(double tarifaPorHora) {
        if (tarifaPorHora <= 0) {
            throw new IllegalArgumentException("La tarifa por hora debe ser mayor que cero.");
        }
        this.tarifaPorHora = tarifaPorHora;
    }

    public void establecerAnosDeServicio(int anosDeServicio) {
        if (anosDeServicio < 0) {
            throw new IllegalArgumentException("Los años de servicio no pueden ser negativos.");
        }
        this.anosDeServicio = anosDeServicio;
    }

    public void establecerEspecialidadConsultor(String especialidadConsultor) {
        this.especialidadConsultor = especialidadConsultor;
    }
}