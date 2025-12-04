//Esta clase hereda de la clase abstracta Consultor
public class ConsultorSenior extends Consultor {

    public ConsultorSenior(String idConsultor, String nombreConsultor, String especialidadConsultor,
                           double tarifaPorHoraBase, int anosDeServicio) {

        super(idConsultor, nombreConsultor, especialidadConsultor, tarifaPorHoraBase, anosDeServicio);
    }

    //Uso de metodos abstractos de Consultor
    @Override
    public double calcularCostoMensualEstimado(int horasMensuales) {
        double costoBase = tarifaPorHoraBase * horasMensuales;
        double bono = costoBase * (anosDeServicio * 0.01);
        return costoBase + bono;
    }

    @Override
    public String obtenerDescripcion() {
        return "Nivel: SENIOR | ID: " + idConsultor + " | Antigüedad: " + anosDeServicio + " años | Tarifa: " + tarifaPorHoraBase;
    }
}