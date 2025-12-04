//Clase abstracta
public abstract class Consultor {

    // Atributos protected para las clases hijas
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

    // Metodo para mostrar info
    public void mostrarInformacionBasica() {
        System.out.println("ID: " + idConsultor + " | Nombre: " + nombreConsultor);
        System.out.println("Especialidad: " + especialidadConsultor + " | Años: " + anosDeServicio);
    }

    //Metodo abstractos
    public abstract double calcularCostoMensualEstimado(int horasMensuales);

    public abstract String obtenerDescripcion();

    // Getters
    public String getIdConsultor() { return idConsultor; }
    public String getNombreConsultor() { return nombreConsultor; }
    public String getEspecialidadConsultor() { return especialidadConsultor; }
    public int getAnosDeServicio() { return anosDeServicio; }

}