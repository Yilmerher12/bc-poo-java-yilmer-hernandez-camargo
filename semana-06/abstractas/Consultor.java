package abstractas;

public abstract class Consultor {

    // Atributos PROTECTED
    protected String idConsultor;
    protected String nombreConsultor;
    protected String especialidadConsultor;
    protected double tarifaPorHoraBase;
    protected int anosDeServicio;

    // Constructor
    public Consultor(String idConsultor, String nombreConsultor, String especialidadConsultor,
                     double tarifaPorHoraBase, int anosDeServicio) {
        this.idConsultor = idConsultor;
        this.nombreConsultor = nombreConsultor;
        this.especialidadConsultor = especialidadConsultor;
        this.tarifaPorHoraBase = tarifaPorHoraBase;
        this.anosDeServicio = anosDeServicio;
    }

    // Metodo normal
    public void mostrarInformacionBasica() {
        System.out.println("ID: " + idConsultor + " | Nombre: " + nombreConsultor);
        System.out.println("Especialidad: " + especialidadConsultor + " | Años: " + anosDeServicio);
    }

    // Metodo abstracto
    public abstract double calcularCostoMensualEstimado(int horasMensuales);

    // Metodo ABSTRACTO
    public abstract String obtenerDescripcion();

    // Getters
    public String getIdConsultor() {
        return idConsultor;
    }
    public String getNombreConsultor() {
        return nombreConsultor;
    }
    public int getAnosDeServicio() {
        return anosDeServicio;
    }
}