public class Consultor {

    // ATRIBUTOS PRIVATE (Estado final Semana 03)
    private String idConsultor;
    private String nombreConsultor;
    private String especialidadConsultor;
    private double tarifaPorHora;
    private int anosDeServicio; 

    // CONSTRUCTOR 1
    public Consultor(String idConsultor, String nombreConsultor, String especialidadConsultor, double tarifaPorHora, int anosDeServicio) {
        setIdConsultor(idConsultor);
        setNombreConsultor(nombreConsultor);
        this.especialidadConsultor = especialidadConsultor;
        setTarifaPorHora(tarifaPorHora);
        setAnosDeServicio(anosDeServicio);
    }

    // SOBRECARGA DE CONSTRUCTORES
    public Consultor(String idConsultor, String nombreConsultor, String especialidadConsultor, double tarifaPorHora) {
        this(idConsultor, nombreConsultor, especialidadConsultor, tarifaPorHora, 0);
    }
    public Consultor(String idConsultor, String nombreConsultor) {
        this(idConsultor, nombreConsultor, "General", 30.0, 0);
    }

    // MÉTODOS
    public double calcularCostoMensualEstimado(int horasMensuales) {
        return this.tarifaPorHora * horasMensuales;
    }
    public void mostrarInformacionBase() {
        System.out.println("ID: " + this.idConsultor + " | Nombre: " + this.nombreConsultor + 
    " | Especialidad: " + this.especialidadConsultor +
    " | Tarifa Base: $" + this.tarifaPorHora);
    }

    // GETTERS y SETTERS
    private boolean esIdValido(String id) {
        return id != null && id.toUpperCase().startsWith("C") && id.length() >= 4;
    }
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
    public int getAnosDeServicio() { 
        return anosDeServicio; 
    }

    public void setIdConsultor(String idConsultor) {
        if (!esIdValido(idConsultor)) {
            throw new IllegalArgumentException("ID inválido. Debe empezar con 'C' y tener al menos 4 caracteres.");
        }
        this.idConsultor = idConsultor;
    }
    public void setNombreConsultor(String nombreConsultor) {
        if (nombreConsultor == null || nombreConsultor.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del consultor no puede ser vacío.");
        }
        this.nombreConsultor = nombreConsultor;
    }
    public void setTarifaPorHora(double tarifaPorHora) {
        if (tarifaPorHora <= 0) {
            throw new IllegalArgumentException("La tarifa por hora debe ser mayor que cero.");
        }
        this.tarifaPorHora = tarifaPorHora;
    }
    public void setAnosDeServicio(int anosDeServicio) {
        if (anosDeServicio < 0) {
            throw new IllegalArgumentException("Los años de servicio no pueden ser negativos.");
        }
        this.anosDeServicio = anosDeServicio;
    }
    public void setEspecialidadConsultor(String especialidadConsultor) { this.especialidadConsultor = especialidadConsultor; }
}