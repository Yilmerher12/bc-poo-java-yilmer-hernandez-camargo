public class ConsultorJunior extends Consultor {
    private double tarifaReducidaFija;

    // CONSTRUCTOR
    public ConsultorJunior(String idConsultor, String nombreConsultor, String especialidadConsultor, double tarifaPorHora, int anosDeServicio, double tarifaReducidaFija) {
        // Llama al constructor del padre (Consultor)
        super(idConsultor, nombreConsultor, especialidadConsultor, tarifaPorHora, anosDeServicio);
        this.tarifaReducidaFija = tarifaReducidaFija;
    }

    // Se sobreescribe el metodo heredado
    @Override
    public double calcularCostoMensualEstimado(int horasMensuales) {

        double costoBase = super.calcularCostoMensualEstimado(horasMensuales);

        return costoBase - this.tarifaReducidaFija;
    }
}