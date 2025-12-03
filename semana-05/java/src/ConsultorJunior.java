// Archivo: ConsultorJunior.java
public class ConsultorJunior extends Consultor {

    private final double TARIFA_REDUCIDA_FIJA = 25.0;

    public ConsultorJunior(String idConsultor, String nombreConsultor, String especialidadConsultor, double tarifaPorHora, int anosDeServicio) {
        super(idConsultor, nombreConsultor, especialidadConsultor, tarifaPorHora, anosDeServicio);
    }

    //Metodo para sobreescribir el costo
    @Override
    public double calcularCostoMensualEstimado(int horasMensuales) {
        // Ignoramos la tarifa de la clase padre y usamos la tarifa fija reducida.
        return TARIFA_REDUCIDA_FIJA * horasMensuales;
    }

    //Metodo para sobreescribir la descripcion
    @Override
    public String obtenerDescripcion() {
        return "CONSULTOR JUNIOR: " + getNombreConsultor() + " | Tarifa reducida: $" + TARIFA_REDUCIDA_FIJA + "/hr";
    }
}