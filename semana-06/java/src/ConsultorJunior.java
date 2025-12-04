//Esta clase hereda de la clase abstracta Consultor
public class ConsultorJunior extends Consultor {
    // Tarifa fija reducida, por ejemplo, 40.0
    private static final double TARIFA_FIJA_REDUCIDA = 40.0;

    public ConsultorJunior(String idConsultor, String nombreConsultor, String especialidadConsultor,
                           double tarifaPorHoraBase, int anosDeServicio) {
        super(idConsultor, nombreConsultor, especialidadConsultor, tarifaPorHoraBase, anosDeServicio);
    }

    //Uso de metodos abstractos de Consultor
    @Override
    public double calcularCostoMensualEstimado(int horasMensuales) {
        // Ignora la tarifa base del padre y usa la tarifa fija reducida.
        return TARIFA_FIJA_REDUCIDA * horasMensuales;
    }

    @Override
    public String obtenerDescripcion() {
        return "Nivel: JUNIOR | ID: " + idConsultor + " | Tarifa Fija: " + TARIFA_FIJA_REDUCIDA + " (Ignora Tarifa Base)";
    }
}