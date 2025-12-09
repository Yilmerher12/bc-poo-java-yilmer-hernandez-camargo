public class Consultor {

    // Atributos
    private String idConsultor;
    private String nombreConsultor;
    private String especialidadConsultor; // Relación con el área de proyecto
    private double tarifaPorHora;
    private int aniosDeServicio;

    // Constructor
    public Consultor(String idConsultor, String nombreConsultor, String especialidadConsultor, double tarifaPorHora, int aniosDeServicio) {
        this.idConsultor = idConsultor;
        this.nombreConsultor = nombreConsultor;
        this.especialidadConsultor = especialidadConsultor;
        this.tarifaPorHora = tarifaPorHora;
        this.aniosDeServicio = aniosDeServicio;
    }

    // Métodos de Negocio
    public double calcularCostoMensualEstimado(int horasMensuales) {
        // Asume un mes laboral estándar para estimar el costo fijo.
        return this.tarifaPorHora * horasMensuales;
    }

    // Getters
    public String getIdConsultor() {
        return idConsultor;
    }

    public String getNombreConsultor() {
        return nombreConsultor;
    }

    public String getEspecialidadConsultor() {
        return especialidadConsultor;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public int getAniosDeServicio() {
        return aniosDeServicio;
    }

    // Setters
    public void setTarifaPorHora(double tarifaPorHora) {
        if (tarifaPorHora > 0) {
            this.tarifaPorHora = tarifaPorHora;
        }
    }

    public void setEspecialidadConsultor(String especialidadConsultor) {
        this.especialidadConsultor = especialidadConsultor;
    }
}