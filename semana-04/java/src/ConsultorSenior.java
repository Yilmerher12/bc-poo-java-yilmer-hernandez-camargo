public class ConsultorSenior extends Consultor {

    // CONSTRUCTOR
    public ConsultorSenior(String idConsultor, String nombreConsultor, String especialidadConsultor, double tarifaPorHora, int anosDeServicio) {
        // Llama al constructor de la clase padre (Consultor)
        super(idConsultor, nombreConsultor, especialidadConsultor, tarifaPorHora, anosDeServicio);
    }

    // Se sobreescribe el metodo heredado
    // El Senior recibe un bono del 1% por cada año de servicio.
    @Override
    public double calcularCostoMensualEstimado(int horasMensuales) {

        double costoBase = super.calcularCostoMensualEstimado(horasMensuales);

        double bono = costoBase * 0.01 * anosDeServicio;

        return costoBase + bono;
    }
}