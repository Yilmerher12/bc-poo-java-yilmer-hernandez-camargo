// Archivo: ConsultorSenior.java
public class ConsultorSenior extends Consultor {

    private final double BONO_POR_ANO = 0.01; // 1%

    public ConsultorSenior(String idConsultor, String nombreConsultor, String especialidadConsultor, double tarifaPorHora, int anosDeServicio) {
        super(idConsultor, nombreConsultor, especialidadConsultor, tarifaPorHora, anosDeServicio);
    }

    //Metodo para sobreescribir el costo
    @Override
    public double calcularCostoMensualEstimado(int horasMensuales) {
        double costoBase = super.calcularCostoMensualEstimado(horasMensuales);
        double bono = costoBase * (getAnosDeServicio() * BONO_POR_ANO);
        return costoBase + bono;
    }

    //Metodo para sobreescribir la descripcion
    @Override
    public String obtenerDescripcion() {
        return "CONSULTOR SENIOR: " + getNombreConsultor() + " | Antigüedad: " + anosDeServicio + " años | Bono: " + (int)(anosDeServicio * 100 * BONO_POR_ANO) + "%";
    }
}